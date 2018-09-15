
@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.2')

import groovy.json.*

import org.apache.http.client.methods.*
import org.apache.http.entity.*
import org.apache.http.impl.client.*

def hostUrl = 'http://localhost:3130'

def buildJSON = { response ->
    def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
    def jsonResponse = bufferedReader.getText()
    return JsonOutput.prettyPrint(jsonResponse)
}

def hitEndpoint = { url ->
    def httpGet = new HttpGet(url)
    def client = HttpClientBuilder.create().build()
    def response = client.execute(httpGet)
    println "response: \n" + buildJSON(response)
    println " -------------------------- "
}

// --------------- main

if (args.size() >= 1) {
    def endpoint = args[0]
    hitEndpoint("${hostUrl}/${endpoint}")

    println "Ready."
} else {
    println "Usage: ClientActuator.groovy endpoint"
}
