@Program_module
Feature: Test LMS api program module with BaseUrl and Endpoints with Negative scenarios
  Background:
  Given User sets Authoization to "No Auth"

  @POST_NegativeByMissingProgramName @Negative
  Scenario Outline: validating User able to create a program with valid endpoint and missing ProgramName Field
    Given User is provided with the BaseUrl and endpoint with missing ProgramName to create a POST Request with missing programname
    When  User send the HTTPsPOST request to server with the missing ProgramName from "<sheetname>" and <rownumber>
    Then  User validates the response with status code "201" from post
    Examples:
			| sheetname |rownumber|
			| user			| 0   |			
			

	
#			@GET_NegativeByInvalidprogramId @Negative
  #Scenario: validating User able to retrieve program with Invalid programID
    #Given User is provided with the BaseUrl and the Endpoints to create a GET request
    #When  User send the HTTPsGET request with invalid programID
    #Then  User validates the response with status code, response time, header
  #
   #@PUT_NegativeUsingInvalidProgramID @Negative
  #Scenario: validating user able to update a program with invalid programID and Payload
    #Given User is provided with the BaseUrl and the Endpoints to update status with invalid programID
    #When  User send the HTTPsPUT request with invalid programID
    #Then  User validates the response with status code, response time, header
    #
    #@PUT_NegativeUsingvalidProgramIDMissingStatus @Negative
  #Scenario: validating user able to update a program with valid programID and missing programName field in payload
    #Given User is provided with the BaseUrl and the Endpoints to update status with missing programName in payload
    #When  User send the HTTPsPUT request with valid programID
    #Then  User validates the response with status code, response time, header
    #
    #@PUT_NegativeUsingInvalidProgramName @Negative
  #Scenario: validating user able to update a program with invalid programName and Payload
    #Given User is provided with the BaseUrl and the Endpoints to update status with invalid programName
    #When  User send the HTTPsPUT request with invalid programName
    #Then  User validates the response with status code, response time, header
    #
   #@PUT_NegativeUsingvalidProgramNameMissingStatus @Negative
  #Scenario: validating user able to update a program with missing programName and Payload
    #Given User is provided with the BaseUrl and the Endpoints to update status with missing program status
    #When  User send the HTTPsPUT request with missing program status
    #Then  User validates the response with status code, response time, header    
   #
   #
    #@DELETE_NegativeWithInvalidProgramName @Negative
  #Scenario: validating user able to delete a program with invalid programName 
    #Given User is provided with the BaseUrl and the Endpoints to delete a program with invalid programName 
    #When User send the HTTPsDELETE request with invalid programName
    #Then User validates the response with status code, response time, header
    #
    #@DELETE_NegativeWithInvalidProgramID @Negative
  #Scenario: validating user able to delete a program with valid programId 
    #Given User is provided with the BaseUrl and the Endpoints to delete a program with valid programId 
    #When User send the HTTPsDELETE request with invalid programId
    #Then User validates the response with status code, response time, header
  