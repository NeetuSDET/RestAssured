package util_Modules;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Config_Reader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
public class AProgramModule {
	private String noAuth;
	private String programdescription,putprogramId;
	private String progname,progName;
	private static String progidinvalid,programNamestr;
	private String progstatus;
	private static Response response;
	public static String programId;
	public static String progid;
	RequestSpecification requestSpecification;
	private static String progNameinvalid;
	private static Config_Reader configreader=new Config_Reader();

	public RequestSpecification noAuthentication(String noauth)
	{
		noAuth=noauth;	
		RequestSpecification requestSpecification = RestAssured.given()
			.header("Authorization", noauth).contentType("application/json");
	return requestSpecification;
	}

	public void getDatafromExcel(String sheetname, int rownumber) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		ExcelReader reader = new ExcelReader();
		String data[]=new String[2];
		List<Map<String, String>> testdata;
		try {
			 testdata = reader.getData(Config_Reader.excelpath(), sheetname);
			 programdescription = testdata.get(rownumber).get("programDescription");	
			 progname= testdata.get(rownumber).get("programName");
			 progstatus= testdata.get(rownumber).get("programStatus");
			  progidinvalid = testdata.get(rownumber).get("invalidprogramID");
			  progNameinvalid=testdata.get(rownumber).get("invalidprogramName");
			  
			 
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			}
	
	
	public Response postprogram(String postUri)
	{
		JSONObject jsonObject = new JSONObject();
		String s = RandomStringUtils.randomNumeric(3); 
		  programNamestr=progname+s;
		  System.out.println(programNamestr);
		jsonObject.put("programDescription",programdescription);
		jsonObject.put("programName", programNamestr);
		jsonObject.put("programStatus", progstatus);
		String payload = jsonObject.toString();
		response = noAuthentication(noAuth).body(jsonObject).post(postUri).then().log().all().extract().response();		
		programId=response.jsonPath().getString("programId");
		progName=response.jsonPath().getString("programName");
		LoggerLoad.info("post request sent with valid data");
	//	System.out.println("input data************"+programdescription+programNamestr+progstatus);
		
		System.out.println(response.jsonPath().prettyPrint());
		
		return response;
	}
	
	
	public Response putprogram(String postUri)
	{
		JSONObject jsonObjectput = new JSONObject();
		String s = RandomStringUtils.randomNumeric(3); 
		  programNamestr=progname+s+"modified";
		  System.out.println(programNamestr);
		  jsonObjectput.put("programDescription",programdescription);
		  jsonObjectput.put("programName", programNamestr);
		  jsonObjectput.put("programStatus", progstatus);
		String payload = jsonObjectput.toString();
		Response response = noAuthentication(noAuth).body(jsonObjectput).post(postUri).then().log().all().extract().response();			
		putprogramId=response.jsonPath().getString("programId from putprogram module" + response.jsonPath().getString("programName"));
	//	System.out.println("input data************"+programdescription+programNamestr+progstatus);
		
		System.out.println(response.jsonPath().prettyPrint() + putprogramId);
		
		return response;
	}
	public String invalidpostprogram(String postUri)
	{
		JSONObject jsonObjectpost = new JSONObject();
		jsonObjectpost.put("programDescription",programdescription);
		jsonObjectpost.put("programName", progNameinvalid);
		jsonObjectpost.put("programStatus", progstatus);
		//String payload = jsonObject.toString();
		String endpoint=postUri+Config_Reader.deleteprogramByidEndpoint()+progNameinvalid;
		System.out.println(endpoint+"******from invalid id");
		String responseinvalid = progidinvalid;		
		///programId=response.jsonPath().getString("programId");
		//Assert.assertEquals(false, null);
		//System.out.println(responseinvalid.jsonPath().prettyPrint()+ "from invalid");
		return responseinvalid;
	}

	

	public void deletebyprogramid(String progID, String deleteEndpoint) {
		given()	
		.when()
		 .delete(deleteEndpoint+progidinvalid)
		.then() 
		  .statusCode(200)
		//  .statusLine(success)
		  .log().all();
		
		System.out.println(deleteEndpoint+programId +"****************** deletepoint");
		System.out.println("response class****"+Response.class);
	}
	
	public void deletebyprogramName( String deleteEndpoint) {
		given()	
		.when()
		 .delete(deleteEndpoint+progidinvalid)
		.then() 
		  .statusCode(200)
		//  .statusLine(success)
		  .log().all();
		
		System.out.println(deleteEndpoint+programId +"****************** deletepoint");
		System.out.println("response class****"+Response.class);
	}

	public void getAllPrograms(String postURI) throws IOException {
		//File expectedJson = new File(configreader.testDataResourcePath());
		//String expectedJson = FileUtils.readFileToString(new File(configreader.testDataResourcePath()));
	    
	//System.out.println("path************ " + expectedJson + "     "+ postURI);
		response=given()
		   .header("Content-Type","application/json")
			.when()
			   .get(postURI);
//			.then()
//			 .assertThat()
//			// .body(JsonSchemaValidator.matchesJsonSchema (new File("C://Users//subas//Rest-Assure-Hackathon//Rest_Assure_Hackathon//getallprogramSchema.json")));
//			 .statusCode(200)
//			 .log().all();
		System.out.println("path************DONE ");
	 
	}

	public void getAllProgramsbyID(String postURI) {
		String programId="10739";
		RestAssured.given()
		   .header("Content-Type","application/json")
		  // .params("progID","10739")
			.when()
			   .get(postURI)
			 .then()
		 	 .assertThat()
			// .body(matchesJsonSchemaInClasspath("Schema.json"))
			 .body(matchesJsonSchemaInClasspath("Schema.json"))
			 .log().all();
		
		
		System.out.println("path************DONE ");
	}

	
}
