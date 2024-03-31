@tag
Feature: User Login Post Request

 @tag1
 Scenario: Check if Admin able to generate token with valid credential
 
    Given Admin creates request with valid credentials 
    When Admin calls Post Https method  with valid endpoint
    Then Admin receives 201 created with auto generated token                                                          
    












 # @tag1
 # Scenario: Check User is able to login with valid credintials,valid URL and valid endpoint
  #  Given User is provided with Base URL and Request body from the "<sheetName>"
 #   When user send the Post request
 #   Then user validate the response
    
  #  Examples:
  #  |  sheetName  |
  #  |  REST       |