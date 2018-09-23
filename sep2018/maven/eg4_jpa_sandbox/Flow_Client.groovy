
@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.2')

import groovy.json.*

import org.apache.http.client.methods.*
import org.apache.http.entity.*
import org.apache.http.impl.client.*

def BOOKS_ENDPOINT = 'http://localhost:7170/api/mega/books'
def ITEMS_ENDPOINT = 'http://localhost:7170/api/mega/items'
def QUESTIONS_ENDPOINT = 'http://localhost:7170/api/mega/questions'
def QUESTION_GROUP_ENDPOINT = 'http://localhost:7170/api/mega/question_group'
def CODES_ENDPOINT = 'http://localhost:7170/api/mega/codes'
def ANSWERS_ENDPOINT = 'http://localhost:7170/api/mega/answers'

def UPDATE_ANSWER_ENDPOINT = 'http://localhost:7170/api/mega/answers/%d'

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

def updateAnswer = { answerId, answerValue  ->
    def url = String.format(UPDATE_ANSWER_ENDPOINT, answerId)
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
        updateAnswer(answer['id'], input)
    
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
