@Batch_module
Feature: Test LMS apis program module with rest assured library and cucumber framework
  Background:
  Given User sets Authoization to "No Auth" from batch

  @Post
  Scenario Outline:
 
		Given  User creates POST Request for the Batch LMS API endpoint  
		When User sends HTTPS Request for batch and  request Body with mandatory , additional using "<SheetName>" and <Rowno>        
		Then User receives 201 Created Status with response body.
 		Examples:
				|SheetName|Rowno|
 			  |user|0|

   

  #@GET
 # Scenario: LMS_api's GET request
  #  Given User is provided with the BaseUrl and the Endpoints
  #  When User send the GET request
  #  Then User validate the Response

 #@PUT
 # Scenario: LMS_api's PUT request
 #   Given User is provided with the BaseUrl and the Endpoints
 #   When User send the PUT request
 #   Then User validate the Response
    
  #  @DELETE
  #Scenario: LMS_api's DELETE request
  #  Given User is provided with the BaseUrl and the Endpoints
   # When User send the DELETE request
  #  Then User validate the Response
  