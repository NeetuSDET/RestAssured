@Assignment_module
Feature: Test LMS apis program module with rest assured library and cucumber framework
  ​

  @Post_MissingAssignmentFields @Negative
  Scenario Outline: Add the assignment with missing Parameters
    Background : No Authorization required

    Given User is provided with the BaseUrl and endpoint and missing fields in payload
    When User send the HTTPsPOST request to server with the payload from "<sheetname>" and <rownumber>
    Then User validates the response with status code 400

  @GET_NegativeByInvalidAssignmentID @Negative
  Scenario: validating User able to retrieve assignments with invalid asssignmentID
    Given User is provided with the BaseUrl and the Endpoints to create a GET request with invalid assignment id
    When User send the HTTPsGET request with invalid assignmentID
    Then User receives 404 not found request Status with response body

  @GET_NegativeAssignmentByValidBatchID @Negative
  Scenario: validating User able to retrieve assignments with invalid BatchID
    Given User is provided with the BaseUrl and the Endpoints to create a GET request with invalid batch id
    When User send the HTTPsGET request with invalid batchID
    Then User receives 404 not found request Status with response body

  @DELETE_NegativeInValidAssignmentID @Negative
  Scenario: validating user able to delete a assignment with invalid assignmentId
    Given User is provided with the BaseUrl and the Endpoints to delete a assignment with invalid assignmentId
    When User send the HTTPsDELETE request with invalid assignmentId
    Then User receives 404 Status with response body

  @PUT_PositiveUsingInValidassignmentID @Negative
  Scenario Outline: validating user able to update a assignment with invalid assignmentID and Payload
    Given User is provided with the BaseUrl and the Endpoints to update status with invalid assignmentID
    When User send the HTTPsPUT request with invalid assignmentID and the payload from "<sheetname>" and <rownumber>
    Then User receives 404 not found request Status with response body for update assignment

    Examples: 
      | sheetname | rownumber |
      | user      |      4393 |

  @PUT_PositiveUsingInValidassignmentID @Negative
  Scenario Outline: validating user able to update a assignment with invalid assignmentID and Payload
    Given User is provided with the BaseUrl and the Endpoints to update status with invalid parameter
    When User send the HTTPsPUT request with invalid parameter and the payload from "<sheetname>" and <rownumber>
    Then User receives 400 Status with response

    Examples: 
      | sheetname | rownumber |
      | user      |      4393 |
#
  #@Post_duplicateAssignment @Negative
  #Scenario Outline: Add the assignment with duplicate parameters
    #Given User is provided with the BaseUrl and endpoint with duplicate assignment in payload
    #When User send the HTTPsPOST request to server with the payload from "<sheetname>" and <rownumber>
    #Then User validates the response with status code 400
