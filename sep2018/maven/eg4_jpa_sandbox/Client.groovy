
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

def buildJSON = { response ->
    def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
    def jsonResponse = bufferedReader.getText()
    return JsonOutput.prettyPrint(jsonResponse)
}

def getThings = { endpoint ->
    def httpGet = new HttpGet(endpoint)
    def client = HttpClientBuilder.create().build()
    def response = client.execute(httpGet)
    println buildJSON(response)
}

//////////////////////
// pretty print item

def doUseCase1 = { 
    def client = HttpClientBuilder.create().build()
    def slurper = new JsonSlurper()

    def httpGet = new HttpGet(ITEMS_ENDPOINT)
    def response = client.execute(httpGet)
    def jsonResponse = buildJSON(response)
    def doc = slurper.parseText(jsonResponse)
    def item = doc[0]
    def answers = item['answers']

    // println item
    println "item id: " + item['id']
    println "item name: " + item['name']
    println "# answers: " + answers.size()

    answers.each { a ->
        def q = a['question']
        def c = q['code']
        def values = c['values']
    
        def valuesStr = values.inject("") { acc, value ->
            acc + " | " + value['desc']
        }

        println "answer id: " + a['id']
        println "answer text: " + a['answerText']
        println "    question id: ${q['id']} desc: ${q['desc']} code: ${c['id']}"
        println "    question values: ${valuesStr}"
    }
}

//////////////////////
// pretty print questions/group

def doUseCase2 = { 
    def client = HttpClientBuilder.create().build()
    def slurper = new JsonSlurper()

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

def choice = args[0]

if (! choice) {
    println "usage: provide choice"
} else if (choice.equalsIgnoreCase('books')) {
    getThings(BOOKS_ENDPOINT)
} else if (choice.equalsIgnoreCase('items')) {
    getThings(ITEMS_ENDPOINT)
} else if (choice.equalsIgnoreCase('q2')) {
    getThings(QUESTION_GROUP_ENDPOINT)
} else if (choice.equalsIgnoreCase('questions')) {
    getThings(QUESTIONS_ENDPOINT)
} else if (choice.equalsIgnoreCase('codes')) {
    getThings(CODES_ENDPOINT) 
} else if (choice.equalsIgnoreCase('answers')) {
    getThings(ANSWERS_ENDPOINT) 
} else if (choice.equalsIgnoreCase('uc1')) {
    doUseCase1()
} else if (choice.equalsIgnoreCase('uc2')) {
    doUseCase2()
}
