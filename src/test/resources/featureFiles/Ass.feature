@Assignment_module
Feature: Test LMS apis program module with rest assured library and cucumber framework

  #Background:
  #Given User sets Authoization to "No Auth" from assignment
  @GET_PositiveAllAssignments @positive @getallassignments
  Scenario: validating User able to retrieve all assignments with valid endpoint
    Given User creates GET Request for the Batch LMS API endpoint
    When User send the HTTPsGET request for assignment
    Then User receives 200 OK Status with response body

  @GET_PositiveByValidAssignmentID @positive
  Scenario: validating User able to retrieve assignments with valid asssignmentID
    Given User is provided with the BaseUrl and the Endpoints to create a GET request with valid assignment id
    When User send the HTTPsGET request with valid assignmentID
    Then User receives 200 OK Status with response body

  @GET_PositiveAssignmentByValidBatchID @positive
  Scenario: validating User able to retrieve assignments with valid BatchID
    Given User is provided with the BaseUrl and the Endpoints to create a GET request with valid batch id
    When User send the HTTPsGET request with valid batchID
    Then User receives 200 OK Status with response body

  @Post_PositiveAssignment @positive
  Scenario Outline: 
    Given User creates POST Request for the Assignment LMS API endpoint
    When User sends HTTPS Request for assignment and  request Body with mandatory , additional using "<SheetName>" and <Rowno>
    Then User receives 201 Created Status with response body.

    Examples: 
      | SheetName | Rowno |
      | user      |     0 |

  @DELETE_PositiveValidAssignmentID @positive
  Scenario: validating user able to delete a assignment with valid assignmentId
    Given User is provided with the BaseUrl and the Endpoints to delete a assignment with valid assignmentId
    When User send the HTTPsDELETE request with valid assignmentId
    Then User receives 200 OK Status with response body for delete assignment

  @PUT_PositiveUsingValidassignmentID @positive
  Scenario Outline: validating user able to update a assignment with valid assignmentID and Payload
    Given User is provided with the BaseUrl and the Endpoints to update status with valid assignmentID
    When User send the HTTPsPUT request with valid assignmentID and the payload from "<sheetname>" and <rownumber>
    Then User receives 200 OK Status with response body for update assignment

    Examples: 
      | sheetname | rownumber |
      | user      |      4965 |
