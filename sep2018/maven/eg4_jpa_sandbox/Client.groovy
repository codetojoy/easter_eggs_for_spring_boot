
@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.2')

import groovy.json.*

import org.apache.http.client.methods.*
import org.apache.http.entity.*
import org.apache.http.impl.client.*

def BOOKS_ENDPOINT = 'http://localhost:7170/api/mega/books'
def ITEMS_ENDPOINT = 'http://localhost:7170/api/mega/items'
def QUESTIONS_ENDPOINT = 'http://localhost:7170/api/mega/questions'
def CODES_ENDPOINT = 'http://localhost:7170/api/mega/codes'

def buildJSON = { response ->
    def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
    def jsonResponse = bufferedReader.getText()
    return JsonOutput.prettyPrint(jsonResponse)
}

def getThings = { endpoint ->
    def httpGet = new HttpGet(endpoint)
    def client = HttpClientBuilder.create().build()
    def response = client.execute(httpGet)
    println "response: \n" + buildJSON(response)
    println " -------------------------- "
}

// --------------- main

def choice = args[0]

if (! choice) {
    println "usage: provide choice"
} else if (choice.equalsIgnoreCase('books')) {
    getThings(BOOKS_ENDPOINT)
} else if (choice.equalsIgnoreCase('items')) {
    getThings(ITEMS_ENDPOINT)
} else if (choice.equalsIgnoreCase('questions')) {
    getThings(QUESTIONS_ENDPOINT)
} else if (choice.equalsIgnoreCase('codes')) {
    getThings(CODES_ENDPOINT) 
}

println "[api] :: Ready."
