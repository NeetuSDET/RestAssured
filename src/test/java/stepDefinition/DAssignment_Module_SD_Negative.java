package stepDefinition;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.LoggerLoad;
import utilities.PageUtils;

public class DAssignment_Module_SD_Negative {

private static String postURI;
//private static int postprogramID;
//public  static String programID,programName,postprogramName;
//private static String PutEndpoint;
//private static String DeleteEndpoint;
//private static String getEndpoint;
//private static String excelsheetname;
private static RequestSpecification request;
//private static String responseinvalid;
//private static Config_Reader configreader=new Config_Reader();
//static Properties prop;
public static Response response;
//private PageUtils pageUtil=new PageUtils();
//private static DAssignmentModule assignment=new DAssignmentModule()
//private String assignment;



////Post
@Given("User is provided with the BaseUrl and endpoint and missing fields in payload")
public void user_is_provided_with_the_base_url_and_endpoint_and_missing_fields_in_payload() {
	postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments";
	  request=RestAssured.given().header("Content-Type","application/json");
	  LoggerLoad.info("***Sending the GetAllBatch Given code***" + postURI);
 
}

@When("User send the HTTPsPOST request to server with the payload from {string} and <rownumber>")
public void user_send_the_htt_ps_post_request_to_server_with_the_payload_from_and_rownumber(String string) {
	JSONObject jsonObject = new JSONObject();
	String s = RandomStringUtils.randomNumeric(3); 
	String assignmentname = "API_REST_ASSURE_NEETUKhatri";
	String programNamestr=assignmentname+s;	
	
	jsonObject.put("assignmentDescription", "Testing_API_Rest_Assure_SDETNeetu");
	jsonObject.put("assignmentName", "API_REST_ASSURE_11");
	jsonObject.put("comments", "Test the API_SDET");
	jsonObject.put("dueDate", "2023-07-27T23:27:07.899+00:00");
	jsonObject.put("pathAttachment1", "Testing API1");
	jsonObject.put("pathAttachment2", "Testing API2");
	jsonObject.put("pathAttachment3", "Testing API3");
	jsonObject.put("pathAttachment4", "Testing API4");
	jsonObject.put("pathAttachment5", "Testing API5");
//	jsonObject.put("batchId", 7536);
	jsonObject.put("graderId", "U7900");
//	programID=response.jsonPath().getString("programId");//this gives all the id in the program module
//	programName = response.jsonPath().getString("programName");		System.out.println("before response"+programID + programName );
	response=request.body(jsonObject.toJSONString()).when().post(postURI).then().log().all().extract().response();
	Object postassignmentName = response.path("programName");//this gives the created programid and name
	Object postassignmentID = response.path("programId");
	System.out.println("after response"+postassignmentID + postassignmentName);
    System.out.println("The status received: " + response.statusLine());
    System.out.println("The status received: " + response.statusCode());
    System.out.println("The status received: " + response.asString());
    System.out.println("The status received: " + response.contentType());
    LoggerLoad.info("****************Program is created valid data*********************");
	System.out.println("value for assignment id and name  "+postassignmentID + postassignmentName);	

}

@Then("User validates the response with status code {int}")
public void user_validates_the_response_with_status_code(Integer int1) {
		Assert.assertEquals(response.statusCode(),int1);
    
}

////Get
@Given("User is provided with the BaseUrl and the Endpoints to create a GET request with invalid assignment id")
public void user_is_provided_with_the_base_url_and_the_endpoints_to_create_a_get_request_with_invalid_assignment_id() {
	postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/10";
	request=RestAssured.given().header("Content-Type","application/json");
    LoggerLoad.info("***Sending the GetAllBatch Given code***" + postURI);

}

@When("User send the HTTPsGET request with invalid assignmentID")
public void user_send_the_htt_ps_get_request_with_invalid_assignment_id() {
	response=request.get(postURI);
	 response.then().log().all();
	 LoggerLoad.info("***user sends the get all request for batch****");
 
}

@Then("User receives {int} not found request Status with response body")
public void user_receives_not_found_request_status_with_response_body(Integer int1) {
	Assert.assertEquals(response.statusCode(),int1);

}
/////GET
@Given("User is provided with the BaseUrl and the Endpoints to create a GET request with invalid batch id")
public void user_is_provided_with_the_base_url_and_the_endpoints_to_create_a_get_request_with_invalid_batch_id() {
	postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/batch/1";
	request=RestAssured.given().header("Content-Type","application/json");
	LoggerLoad.info("***Sending the GetAssignmentID Given code***" + postURI);
}

@When("User send the HTTPsGET request with invalid batchID")
public void user_send_the_htt_ps_get_request_with_invalid_batch_id() {
	String getendpoint="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/batch/4481";
	response=given().when().get(getendpoint).then().log().all().extract().response();
	LoggerLoad.info("***user get getAssignmentsForBatch by sending the batch ID***");	

}

////Delete
@Given("User is provided with the BaseUrl and the Endpoints to delete a assignment with invalid assignmentId")
public void user_is_provided_with_the_base_url_and_the_endpoints_to_delete_a_assignment_with_invalid_assignment_id() {
	postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/4481";
	   LoggerLoad.info("**************given baseurl and endpoint to delete assignment with assignment id****************");


}

@When("User send the HTTPsDELETE request with invalid assignmentId")
public void user_send_the_htt_ps_delete_request_with_invalid_assignment_id() {
	request=RestAssured.given().header("Content-Type","application/json");
	response = given().delete(postURI).then().extract().response();
	
}

@Then("User receives {int} Status with response body")
public void user_receives_status_with_response_body(Integer int1) {
	Assert.assertEquals(response.statusCode(),int1);
}


/////Put
@Given("User is provided with the BaseUrl and the Endpoints to update status with invalid assignmentID")
public void user_is_provided_with_the_base_url_and_the_endpoints_to_update_status_with_invalid_assignment_id() {
		postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/4186";
		   LoggerLoad.info("**************given baseurl and endpoint to update assignment with assignment id****************");

}

@When("User send the HTTPsPUT request with invalid assignmentID and the payload from {string} and {int}")
public void user_send_the_htt_ps_put_request_with_invalid_assignment_id_and_the_payload_from_and(String string, Integer int1) {
	//Random generator = new Random();
			//int i = generator.nextInt(300) + 1;
			JSONObject obj=new JSONObject ();
			String putassignmentID = null;
			LoggerLoad.info("****************s assignmentid*********************"+putassignmentID);
			obj.put("assignmentId",100);
			
			obj.put("assignmentDescription", "Testing updated through put request for Eclipse");
			obj.put("assignmentName","Nee");
			obj.put("createdBy","U9424");
			obj.put("dueDate",PageUtils.duedate());
			obj.put("batchId", "7536");
			obj.put("graderId","U9424");
//			obj.put("pathAttachment2","assg2");
//			obj.put("pathAttachment3","assg3");
//			obj.put("pathAttachment4","assg4");
//			obj.put("pathAttachment5","assg5");
			
			String payload = obj.toString();
			
			response=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toJSONString()).when()
					.put(postURI);
			
			System.out.println("Assignment Responsesssss:\n"+response.jsonPath().prettyPrint());
		
		}


@Then("User receives {int} not found request Status with response body for update assignment")
public void user_receives_not_found_request_status_with_response_body_for_update_assignment(Integer int1) {
	Assert.assertEquals(response.statusCode(),int1);
}


///Put
@Given("User is provided with the BaseUrl and the Endpoints to update status with invalid parameter")
public void user_is_provided_with_the_base_url_and_the_endpoints_to_update_status_with_invalid_parameter() {
	postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/4186";
	   LoggerLoad.info("**************given baseurl and endpoint to update assignment with assignment id****************");

}

@When("User send the HTTPsPUT request with invalid parameter and the payload from {string} and {int}")
public void user_send_the_htt_ps_put_request_with_invalid_parameter_and_the_payload_from_and(String string, Integer int1) {
	//Random generator = new Random();
	//int i = generator.nextInt(300) + 1;
	JSONObject obj=new JSONObject ();
	String putassignmentID = null;
	LoggerLoad.info("****************s assignmentid*********************"+putassignmentID);
	obj.put("assign",100);
	
	obj.put("assignmentDescription", "Testing updated through put request for Eclipse");
	obj.put("assignmentName","Nee");
	obj.put("createdBy","U9424");
	obj.put("dueDate",PageUtils.duedate());
	obj.put("batchId", "7536");
	obj.put("graderId","U9424");
//	obj.put("pathAttachment2","assg2");
//	obj.put("pathAttachment3","assg3");
//	obj.put("pathAttachment4","assg4");
//	obj.put("pathAttachment5","assg5");
	
	String payload = obj.toString();
	
	response=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toJSONString()).when()
			.put(postURI);
	
	System.out.println("Assignment Responsesssss:\n"+response.jsonPath().prettyPrint());

}




@Then("User receives {int} Status with response")
public void user_receives_status_with_response(Integer int1) {
	Assert.assertEquals(response.statusCode(),int1);
}

@Given("User is provided with the BaseUrl and endpoint with duplicate assignment in payload")
public void user_is_provided_with_the_base_url_and_endpoint_with_duplicate_assignment_in_payload() {
	JSONObject jsonObject = new JSONObject();
	String s = RandomStringUtils.randomNumeric(3); 
	String assignmentname = "API_REST_ASSURE_NEETUKhatri";
	String programNamestr=assignmentname+s;	
	
	jsonObject.put("assignmentDescription", "testing Login page");
	jsonObject.put("assignmentName", "");
	jsonObject.put("comments", "Test the API_SDET");
	jsonObject.put("dueDate", "2023-07-27T23:27:07.899+00:00");
	jsonObject.put("pathAttachment1", "Testing API1");
	jsonObject.put("pathAttachment2", "Testing API2");
	jsonObject.put("pathAttachment3", "Testing API3");
	jsonObject.put("pathAttachment4", "Testing API4");
	jsonObject.put("pathAttachment5", "Testing API5");
//	jsonObject.put("batchId", 7536);
	jsonObject.put("graderId", "U7900");
//	programID=response.jsonPath().getString("programId");//this gives all the id in the program module
//	programName = response.jsonPath().getString("programName");		System.out.println("before response"+programID + programName );
	response=request.body(jsonObject.toJSONString()).when().post(postURI).then().log().all().extract().response();
	Object postassignmentName = response.path("programName");//this gives the created programid and name
	Object postassignmentID = response.path("programId");
	System.out.println("after response"+postassignmentID + postassignmentName);
    System.out.println("The status received: " + response.statusLine());
    System.out.println("The status received: " + response.statusCode());
    System.out.println("The status received: " + response.asString());
    System.out.println("The status received: " + response.contentType());
    LoggerLoad.info("****************Program is created valid data*********************");
	System.out.println("value for assignment id and name  "+postassignmentID + postassignmentName);	

}

}

