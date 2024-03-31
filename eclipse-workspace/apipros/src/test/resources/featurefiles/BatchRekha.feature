
@batch
Feature: Programbatch_Postive
  @batch1
  
  Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
   
    Given Admin creates POST Request for the LMS with request body
    When Admin sends HTTPS Request and  request Body with endpoint
    Then Admin receives 201 Created Status with response body.
    
   #@batch2
    # Scenario: Check if Admin able to create a program with missing values in the request body
   
   # Given Admin creates POST Request for the LMS with request body
    #When Admin sends HTTPS Request and  request Body with endpoint with missing field
   # Then Admin receives 500 ok
    

  @GetAllbatch
  Scenario: Check if Admin able to retrieve all batches with valid Endpoint
    
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint batches
    #Then Admin receives 200 OK Status with response body.
    
    
  @Getbatchid
  Scenario: Check if Admin able to retrieve a batches with valid batch ID
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint batchId
    Then Admin receives 200 OK Status with response body.
    
    
  @Getbatchname
  Scenario: Check if Admin able to retrieve all batches with valid batchname
  
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint batchName
    Then Admin receives 200 OK Status with response body.
    
  @Getprogramid
  Scenario: Check if Admin able to retrieve all batches with valid programid
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint programId
    Then Admin receives 200 OK Status with response body.
    
  @updatebatchid
 Scenario: Check if Admin able to update  batches with valid batchid
    Given Admin creates PUT Request for the LMS API
    When Admin sends HTTPS Request with endpoint batchId and request
    Then Admin receives 200 OK Status with response body.
    
  @deletebatchid
  Scenario: Check if Admin able to delete batches with valid batchid
    Given Admin creates DELETE Request for the LMS API
    When Admin sends HTTPS Request with endpoint id
    Then Admin receives 200 OK Status with response body.
    
  @Getbatchid
  Scenario: Check if Admin able to retrieve a batches with valid batch ID
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint batchId
    Then Admin receives 200 OK Status with response body.
  @Getbatchname
  Scenario: Check if Admin able to retrieve all batches with valid batchname
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint batchName
    Then Admin receives 200 OK Status with response body.
  @updatebatchid
  Scenario: Check if Admin able to update  batches with valid batchid
    Given Admin creates PUT Request for the LMS API
    When Admin sends HTTPS Request with endpoint batchId
    Then Admin receives 200 OK Status with response body.