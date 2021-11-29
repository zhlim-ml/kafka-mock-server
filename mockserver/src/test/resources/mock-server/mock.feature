@mockServer
Feature: mock server

Background:
  * configure cors = true
  * def body = []

Scenario: pathMatches('/test') && methodIs('post')
    # sample request can be { "id": 1, "details" : "This is a message"}
    * print request 
    * karate.appendTo(body, request)
    * def responseStatus = 200
    * def response = "Message Accepted"

Scenario: pathMatches('/test/{id}') 
    # GET request path parameter is retrieve as id
    * def id = pathParams.id

    #in-line function declaration 
    * def removeAfterGetFunc = function(x){ return x.id != id }
    * def findIdFunc = function(x){ return x.id == id }
    
    #filtering data with ID and return the value
    * def findId = karate.filter(body, findIdFunc)
    * def response = (findId.length <= 0) ? 'unable to find id, please retry' : findId

    # remove ID that are retrieved
    * def body = karate.filter(body, removeAfterGetFunc)

Scenario: pathMatches('/status')
    * def responseStatus = 200

Scenario: pathMatches('/clear')
    * def body = []
    
Scenario:
    * def responseStatus = 404
    
