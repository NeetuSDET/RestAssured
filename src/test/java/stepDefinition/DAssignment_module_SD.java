package stepDefinition;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONObject;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.json.simple.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Config_Reader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.PageUtils;

//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import lombok.experimental.var;
//import util_Modules.AProgramModule;
//import util_Modules.DAssignmentModule;
//import utilities.Config_Reader;
//import utilities.ExcelReader;
//import utilities.LoggerLoad;
//import utilities.PageUtils;
//
//

public class DAssignment_module_SD {
	
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
private String assignment;

////// Sets no authorization
//@Given("User sets Authoization to {string} from assignment")
//public void user_sets_authoization_to_from_assignment(String string) {
//	assignment.noAuthentication(string);
//
//}


////Get allAssignments

	@Given("User creates GET Request for the Batch LMS API endpoint")
	public void user_creates_get_request_for_the_batch_lms_api_endpoint() {
		postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments";
		  request=RestAssured.given().header("Content-Type","application/json");
		  LoggerLoad.info("***Sending the GetAllBatch Given code***" + postURI);
	   
	}

	@When("User send the HTTPsGET request for assignment")
	public void user_send_the_htt_ps_get_request_for_assignment() {
		response=request.get(postURI);
		 response.then().log().all();
		 LoggerLoad.info("***user sends the get all request for batch****");
	    
	}

	@Then("User receives {int} OK Status with response body")
	public void user_receives_ok_status_with_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),int1);
	   
	}
	
////Get by AssignmentID

	@Given("User is provided with the BaseUrl and the Endpoints to create a GET request with valid assignment id")
	public void user_is_provided_with_the_base_url_and_the_endpoints_to_create_a_get_request_with_valid_assignment_id() {
		postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/3886";
		  request=RestAssured.given().header("Content-Type","application/json");
		  LoggerLoad.info("***Sending the GetAssignmentID Given code***" + postURI);
	    
	}

	@When("User send the HTTPsGET request with valid assignmentID")
	public void user_send_the_htt_ps_get_request_with_valid_assignment_id() {
		String getendpoint="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/3886";
		   response=given().when().get(getendpoint).then().log().all().extract().response();
		   LoggerLoad.info("***user sends the get request by sending the assignment id***");
	    
	}
	
////Get by Batch ID

	
	@Given("User is provided with the BaseUrl and the Endpoints to create a GET request with valid batch id")
	public void user_is_provided_with_the_base_url_and_the_endpoints_to_create_a_get_request_with_valid_batch_id() {
			postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/batch/7536";
			  request=RestAssured.given().header("Content-Type","application/json");
		  LoggerLoad.info("***Sending the GetAssignmentID Given code***" + postURI);
	}	 

	@When("User send the HTTPsGET request with valid batchID")
	public void user_send_the_htt_ps_get_request_with_valid_batch_id() {
		String getendpoint="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/batch/7536";
		   response=given().when().get(getendpoint).then().log().all().extract().response();
	   LoggerLoad.info("***user get getAssignmentsForBatch by sending the batch ID***");	
	}
	
	
	
	////Post for Assignment
	
//	@Given("User creates POST Request for the Assignment LMS API endpoint")
//	public void user_creates_post_request_for_the_assignment_lms_api_endpoint() {
//		postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments";
//		  request=RestAssured.given().header("Content-Type","application/json");
//	  LoggerLoad.info("***Sending the GetAllBatch Given code***" + postURI);
//	   
//	   
//	}

//	@When("User sends HTTPS Request for assignment and  request Body with mandatory field , additional using {string} and {int}")
//	public void user_sends_https_request_for_assignment_and_request_body_with_mandatory_additional_using_and(String string, Integer int1) {
//		JSONObject jsonObject = new JSONObject();
//		String s = RandomStringUtils.randomNumeric(3); 
//		String assignmentname = "API_REST_ASSURE_NEETUKhatri";
//		String programNamestr=assignmentname+s;	
//		
//		jsonObject.put("assignmentDescription", "Testing_API_Rest_Assure_SDETNeetu");
//		jsonObject.put("assignmentName", "API_REST_ASSURE_11");
//		jsonObject.put("comments", "Test the API_SDET");
//	    jsonObject.put("dueDate", "2023-07-27T23:27:07.899+00:00");
//		jsonObject.put("pathAttachment1", "Testing API1");
//		jsonObject.put("pathAttachment2", "Testing API2");
//		jsonObject.put("pathAttachment3", "Testing API3");
//		jsonObject.put("pathAttachment4", "Testing API4");
//		jsonObject.put("pathAttachment5", "Testing API5");
//		jsonObject.put("batchId", 7536);
//		jsonObject.put("graderId", "U7900");
//	//	programID=response.jsonPath().getString("programId");//this gives all the id in the program module
//	//	programName = response.jsonPath().getString("programName");	
//	//	System.out.println("before response"+programID + programName );
//		response=request.body(jsonObject.toJSONString()).when().post(postURI).then().log().all().extract().response();
//		Object postassignmentName = response.path("programName");//this gives the created programid and name
//		Object postassignmentID = response.path("programId");
//		System.out.println("after response"+postassignmentID + postassignmentName);
//	    System.out.println("The status received: " + response.statusLine());
//	    System.out.println("The status received: " + response.statusCode());
//	    System.out.println("The status received: " + response.asString());
//	    System.out.println("The status received: " + response.contentType());
//	    LoggerLoad.info("****************Program is created valid data*********************");
//		System.out.println("value for assignment id and name  "+postassignmentID + postassignmentName);	
//	
//	}
//	
	
	@Given("User creates POST Request for the Assignment LMS API endpoint")
	public void user_creates_post_request_for_the_assignment_lms_api_endpoint() {
		postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments";
		  request=RestAssured.given().header("Content-Type","application/json");
		  LoggerLoad.info("***Sending the GetAllBatch Given code***" + postURI);
	   
	   
	}
	
	@When("User sends HTTPS Request for assignment and  request Body with mandatory , additional using {string} and {int}")
	public void user_sends_https_request_for_assignment_and_request_body_with_mandatory_additional_using_and(String string, Integer int1) {
		
			Random generator = new Random();
			int i = generator.nextInt(300) + 1;
			JSONObject obj=new JSONObject ();
//			ObjectNode objnode = obj.createObjectNode();
			obj.put("assignmentName","Test_Resting_SDET102");
			obj.put("assignmentDescription", "Testing_Features and step Definition");
			obj.put("batchId", 7536);
			obj.put("comments","Testing ABC");
			obj.put("createdBy","U9424");
			obj.put("dueDate",PageUtils.duedate());
			obj.put("graderId", "U9424");
			obj.put("pathAttachment1","assg1");
			obj.put("pathAttachment2","assg2");
			obj.put("pathAttachment3","assg3");
			obj.put("pathAttachment4","assg4");
			obj.put("pathAttachment5","assg5");
			String payload = obj.toString();
			
			response=request.body(obj.toJSONString()).when().post(postURI).then().log().all().extract().response();
//			String createdNestedJsonObject = obj.writerWithDefaultPrettyPrinter().writeValueAsString(objnode);
//			System.out.println("Assignment Request: \n"+ createdNestedJsonObject);
//			Response response = noAuthendication(noAuth).body(payload).post(uri);
//			AssignmentId=response.jsonPath().getString("assignmentId");
			System.out.println("Assignment Responsesssss:\n"+response.jsonPath().prettyPrint());
		
	}
////Delete assignment by AssignmentID


	@Given("User is provided with the BaseUrl and the Endpoints to delete a assignment with valid assignmentId")
	public void user_is_provided_with_the_base_url_and_the_endpoints_to_delete_a_assignment_with_valid_assignment_id() {
		postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/4965";
		   LoggerLoad.info("**************given baseurl and endpoint to delete assignment with assignment id****************");

	}

	@When("User send the HTTPsDELETE request with valid assignmentId")
	public void user_send_the_htt_ps_delete_request_with_valid_assignment_id() {
		request=RestAssured.given().header("Content-Type","application/json");
		response = given().delete(postURI).then().extract().response();
		
	}
	

	@Then("User receives {int} OK Status with response body for delete assignment")
	public void user_receives_ok_status_with_response_body_for_delete_assignment(Integer int1) {
		Assert.assertEquals(response.statusCode(),int1);
	}
	
	
	/////put assignment
	@Given("User is provided with the BaseUrl and the Endpoints to update status with valid assignmentID")
	public void user_is_provided_with_the_base_url_and_the_endpoints_to_update_status_with_valid_assignment_id() {
		postURI="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignments/4186";
		   LoggerLoad.info("**************given baseurl and endpoint to update assignment with assignment id****************");

	}

	@When("User send the HTTPsPUT request with valid assignmentID and the payload from {string} and {int}")
	public void user_send_the_htt_ps_put_request_with_valid_assignment_id_and_the_payload_from_and(String postprogramName, Integer postprogramID) {
		
//		System.out.println("value for program id and name  "+postprogramID + postprogramName);	
//		ExcelReader reader = new ExcelReader();
//		String data[]=new String[2];
//		//String description=RandomStringUtils.randomAlphabetic(5);
//		String description="Quality Analyst";
//		List<Map<String, String>> testdata;
//    	 testdata = reader.getData(Config_Reader.excelpath(), SheetName);
//    	
//		String programdescription = testdata.get(rowno).get("programDescription");	
//		String progname= testdata.get(rowno).get("programName");
//		String progstatus= testdata.get(rowno).get("programStatus");	
//		
//		JSONObject jsonObject = new JSONObject();		
//		jsonObject.put("programDescription",description);
//		jsonObject.put("programId", postprogramID);
//		jsonObject.put("programName",postprogramName);
//		jsonObject.put("programStatus", progstatus);
//		
//		System.out.println("updateing programdesc  "+programID + programdescription );
//		response=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonObject.toJSONString()).when()
//		.put(postURI);
//		//response=request.body(jsonObject.toJSONString()).when().post(postURI).then().log().all().extract().response();
//		postprogramName=response.path("programName");//this gives the created programid and name
//		postprogramID=response.path("programId");
//		System.out.println("after response"+postprogramID + postprogramName);
//		System.out.println(response.asString());
//		System.out.println(programdescription+ "is updated with " +description);
//	    System.out.println("The status received: " + response.statusLine());
//	    System.out.println("The status received: " + response.statusCode());
//	    System.out.println("The status received: " + response.asString());
//	    System.out.println("The status received: " + response.contentType());
//	    LoggerLoad.info("****************successfully updated with programid*********************");
	    
		//Random generator = new Random();
		//int i = generator.nextInt(300) + 1;
		JSONObject obj=new JSONObject ();
		LoggerLoad.info("****************s programid*********************"+postprogramID);
		obj.put("assignmentId",postprogramID);
		
		obj.put("assignmentDescription", "Testing updated through put request for Eclipse");
		obj.put("assignmentName","Nee");
		obj.put("createdBy","U9424");
		obj.put("dueDate",PageUtils.duedate());
		obj.put("batchId", "7536");
		obj.put("graderId","U9424");
//		obj.put("pathAttachment2","assg2");
//		obj.put("pathAttachment3","assg3");
//		obj.put("pathAttachment4","assg4");
//		obj.put("pathAttachment5","assg5");
		
		String payload = obj.toString();
		
		response=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toJSONString()).when()
				.put(postURI);
		
		System.out.println("Assignment Responsesssss:\n"+response.jsonPath().prettyPrint());
	
	}

	@Then("User receives {int} OK Status with response body for update assignment")
	public void user_receives_ok_status_with_response_body_for_update_assignment(Integer int1) {
		Assert.assertEquals(response.statusCode(),int1);
		   
	}

}






























