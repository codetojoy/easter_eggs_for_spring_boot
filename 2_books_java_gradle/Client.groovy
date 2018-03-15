
@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.2')

import groovy.json.*

import org.apache.http.client.methods.*
import org.apache.http.entity.*
import org.apache.http.impl.client.*

def endpoint = 'http://localhost:5150/books'

def buildJSON = { response ->
    def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
    def jsonResponse = bufferedReader.getText()
    return JsonOutput.prettyPrint(jsonResponse)
}

def getBooks = {
    def httpGet = new HttpGet(endpoint)
    def client = HttpClientBuilder.create().build()
    def response = client.execute(httpGet)
    println "response: \n" + buildJSON(response)
    println " -------------------------- "
}

def createBook = { title, author ->
    def map = ["title": title, "author": author]
    def jsonBody = new JsonBuilder(map).toString()

    def post = new HttpPost(endpoint)
    post.addHeader("content-type", "application/json")
    post.setEntity(new StringEntity(jsonBody))
    
    def client = HttpClientBuilder.create().build()
    def response = client.execute(post)
    println "response: \n" + buildJSON(response)
    println " -------------------------- "
}

// --------------- main

getBooks()

createBook("Call of the Wild", "Jack London")

getBooks()

println "Ready."

