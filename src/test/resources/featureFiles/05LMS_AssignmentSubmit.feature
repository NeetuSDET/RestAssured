@Program_module
Feature: Test LMS api's program module with rest assured library and cucumber framework
  

  @POST
  Scenario: LMS_api's POST test
    Given User is provided with the BaseUri and BasePath and payload
    When User send the POST request to server with the payload
    Then User validates the response
   

  @GET
  Scenario: LMS_api's GET request
    Given User is provided with the BaseUrl and the Endpoints
    When User send the GET request
    Then User validate the Response

 @PUT
  Scenario: LMS_api's PUT request
    Given User is provided with the BaseUrl and the Endpoints
    When User send the PUT request
    Then User validate the Response
    
    @DELETE
  Scenario: LMS_api's DELETE request
    Given User is provided with the BaseUrl and the Endpoints
    When User send the DELETE request
    Then User validate the Response
  