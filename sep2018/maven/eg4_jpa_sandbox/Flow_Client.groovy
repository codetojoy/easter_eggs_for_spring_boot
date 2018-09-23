
@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.2')

import groovy.json.*

import org.apache.http.client.methods.*
import org.apache.http.entity.*
import org.apache.http.impl.client.*

def API_ROOT = "http://localhost:7170/api"

def BOOKS_ENDPOINT = "${API_ROOT}/mega/books"
def ITEMS_ENDPOINT = "${API_ROOT}/mega/items"
def QUESTIONS_ENDPOINT = "${API_ROOT}/mega/questions"
def QUESTION_GROUP_ENDPOINT = "${API_ROOT}/mega/question_group"
def CODES_ENDPOINT = "${API_ROOT}/mega/codes"
def ANSWERS_ENDPOINT = "${API_ROOT}/mega/answers"

def UPDATE_ANSWER_ENDPOINT = "${API_ROOT}/mega/answers/%d?answerText=%s&score=%d"
def GET_SCORE_FOR_ANSWER_ENDPOINT = "${API_ROOT}/mega/scores?questionId=%d&valueId=%d"

def client = HttpClientBuilder.create().build()
def slurper = new JsonSlurper()

def buildJSON = { response ->
    def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
    def jsonResponse = bufferedReader.getText()
    return JsonOutput.prettyPrint(jsonResponse)
}

def getThings = { endpoint ->
    def httpGet = new HttpGet(endpoint)
    def response = client.execute(httpGet)
    println buildJSON(response)
}

//////////////////////
// pretty print item

def getScore = { questionId, valueId ->
    def url = String.format(GET_SCORE_FOR_ANSWER_ENDPOINT, questionId, valueId)
    def httpGet = new HttpGet(url)
    def response = client.execute(httpGet)
    def jsonResponse = buildJSON(response)
    def score = slurper.parseText(jsonResponse)
    return score
}

def updateAnswer = { questionId, answerId, inputValue  ->
    def inputValueId = inputValue['id']
    def inputValueDesc = inputValue['desc']

    def score = getScore(questionId, inputValueId)
    def scoreValue = score['scoreValue']
    println "TRACER score is: " + scoreValue

    def url = String.format(UPDATE_ANSWER_ENDPOINT, answerId, inputValueDesc, scoreValue)

    def httpPut = new HttpPut(url)

    def response = client.execute(httpPut)
    def jsonResponse = buildJSON(response)
    println "TRACER answer saved. response: " +  jsonResponse
}

def getItem = { 
    def httpGet = new HttpGet(ITEMS_ENDPOINT)
    def response = client.execute(httpGet)
    def jsonResponse = buildJSON(response)
    def doc = slurper.parseText(jsonResponse)
    def item = doc[0]
    def answers = item['answers']

    println "Hello name: ${item['name']} , let's start" 

    println "# answers: " + answers.size()

    answers.each { answer ->
        def input = ""
        def question = answer['question']
        def questionId = question['id']
        def code = question['code']
        def values = code['values']
        def valuesStr = values.inject("") { acc, value ->
            acc + " | " + value['desc']
        }

        println "Question: " + question['desc']
        println "Values: " + valuesStr
        println "your answer? "
        def scanner = new java.util.Scanner(System.in)
        input = scanner.nextLine()

        println "your answer is: " + input
        def inputValue = values.find { v -> v.desc.equalsIgnoreCase(input) }
        assert inputValue
        updateAnswer(questionId, answer['id'], inputValue)
    
    /*
        def valuesStr = values.inject("") { acc, value ->
            acc + " | " + value['desc']
        }

        println "answer id: ${a['id']} text: ${a['answerText']} score: ${a['score']}"
        println "    question id: ${q['id']} desc: ${q['desc']} code: ${c['id']}"
        println "    question values: ${valuesStr}"
    */
    }
}

//////////////////////
// pretty print questions/group

def doUseCase2 = { 
    def httpGet = new HttpGet(QUESTION_GROUP_ENDPOINT)
    def response = client.execute(httpGet)
    def jsonResponse = buildJSON(response)
    def qList = slurper.parseText(jsonResponse)
    
    qList.each { q ->
        def id = q['id']
        def prefix = q['prefix']
        def qId = q['question']['id']
        def sequence = q['sequence']
        def tier = q['tier']

        println "id: ${id} prefix: ${prefix} q_id: ${qId} sequence: ${sequence} tier: ${tier}"
    }
}

// --------------- main

getItem()

println "Ready."
