Feature: Mock server Test 

Background:
    * url "http://localhost:8080" 
    * def testData = 
    """
        {
            "id": 1,
            "details" : "This is a message",
            "name" : "John"
        }
    """    

Scenario: Verify if mock server is receiving message after POST 
    # define the path 
    * def pathName = "/test/"
    
    # Post method to send testData
    Given path pathName
    And request testData
    
    When method POST
    Then status 200
    And match response == "Message Accepted"
       
    #Call Get to retrieve posted ID.
    Given path pathName + testData.id

    When method GET
    Then status 200
    And match response contains testData

