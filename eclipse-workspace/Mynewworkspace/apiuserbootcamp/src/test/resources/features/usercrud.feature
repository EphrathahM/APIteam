@apibootcamp
Feature: Userapi
 
@PostJson
Scenario:  Check User able to create New User using ExternalJsonfile
     #Given Use creates  POST request with 
     When  User send POST http request with endpoint to create user using jsonfile 
     Then  User receives 201 and with response body for external jsonfile
     
@PostJsonWithExistingEmail
Scenario:  Check User able to create New User using ExternalJsonfile with existing email and contact no
     #Given Use creates  POST request with existing email and contact no
     When  User send POST http request with endpoint to create user using jsonfile containing existing email and contact no 
     Then  User receives 409 and with response body for external jsonfile  
     
@Post
Scenario Outline: Check User able to create New User
     Given Use creates  POST request with "<ScenarioType>" 
     When  User send POST http request with endpoint for "<ScenarioType>" 
     Then  User receives <statusCode> and with response body
  
    Examples:
        | ScenarioType                         | statusCode |
        |  Validdata                           |        201 |
        |  Invalid data                        |        400 |
        |  No auth                             |        401 |
        |  InValid Endpoint                    |        404 | 
        |  Invalid Method                      |        405 |
        |  Invalid Content type                |        415 |
     
                    							 
@Getallusers
Scenario Outline: Check User able to Get all  User
 # Given User creates GET request with "<ScenarioType>" 
   When  User send GET http request with endpoint for "<ScenarioType>" 
   Then  User receives <statusCode> and with response body containing all user details
  
  Examples:
     | ScenarioType                         | statusCode |
 #   |  ValidEndPoint                       |        200 |
     |  InValid Endpoint                    |        404 | 
     |  Invalid Method                      |        405 |
     |  No auth                             |        401 |
 #   |  Invalid Content type                |        415 |
     


@GetUserById
Scenario Outline: Check User able to Get User by Id
# Given User creates GET request with "<ScenarioType>" to get User by Id
  When  User send GET http request with endpoint for "<ScenarioType>" to get User by Id 
  Then  User receives <statusCode> and with response body containing  user with Id details
  
       Examples:
       | ScenarioType                         | statusCode |
       |  ValidEndPoint                       |        200 |
       |  InValid userId                      |        404 | 
       |  Invalid Method                      |        405 |
       |  No auth                             |        401 |
    #  |  Invalid Content type                |        415 |
   
     
 @GetUserByName
Scenario Outline: Check User able to Get User by Name
 #Given User creates GET request with "<ScenarioType>" to get User by Name
  When  User send GET http request with endpoint for "<ScenarioType>" to get User by Name 
  Then  User receives <statusCode> and with response body containing  user with Name details
  
       Examples:
       | ScenarioType                         | statusCode |
       |  ValidEndPoint                       |        200 |
       |  InValid userName                    |        404 | 
       |  Invalid Method                      |        405 |
       |  No auth                             |        401 |
   #   |  Invalid Content type                |        415 |
     
   
@UpdateUserById
Scenario Outline: Check User able to Update User by Id
  Given User creates put request with "<ScenarioType>" to update User by Id
  When  User send put  http request with endpoint for "<ScenarioType>" to update User by Id 
  Then  User receives <statusCode> and with response body containing user details for put request
  
       Examples:
       | ScenarioType                         | statusCode |
       |  Validdata                           |        200 |  
       |  Invalid data                        |        400 |
       |  No auth                             |        401 |
       |  InValid Id                          |        404 | 
       |  Invalid Method                      |        405 |
       |  Invalid Content type                |        415 |
       
       
  @DeleteUserByName
Scenario Outline: Check User able to Delete User by Name
 # Given User creates Delete request with "<ScenarioType>" to Delete User by Name
  When  User send  Delete  http request with endpoint for "<ScenarioType>" to Delete User by Name
   Then  User receives <statusCode> and with response body containing delete details 
  
       Examples:
       | ScenarioType                         | statusCode |
       |  ValidEndPoint                       |        200 |
       |  InValid userName                    |        404 | 
       |  Invalid Method                      |        405 |
       |  No auth                             |        401 |
   #   |  Invalid Content type                |        415 |
         
     
  @DeleteUserId
Scenario Outline: Check User able to Delete User by Name
 # Given User creates Delete request with "<ScenarioType>" to Delete User by Id
  When  User send  Delete  http request with endpoint for "<ScenarioType>" to Delete User by Id
  Then  User receives <statusCode> and with response body containing delete details 
  
       Examples:
       | ScenarioType                         | statusCode |
       |  ValidEndPoint                         |        200 |  
       |  InValid userId                      |        404 | 
       |  Invalid Method                      |        405 |
       |  No auth                             |        401 |
  #    |  Invalid Content type                |        415 |    
     
     
     
     
     
                   							                    							   