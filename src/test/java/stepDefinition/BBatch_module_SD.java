package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import util_Modules.AProgramModule;
import util_Modules.BBatchModule;
import utilities.Config_Reader;
import utilities.LoggerLoad;
import utilities.PageUtils;

public class BBatch_module_SD {
	private static Config_Reader configreader=new Config_Reader();
	 static Properties prop;
	 private PageUtils pageUtil=new PageUtils();
	 private static String postURI;
	    private static BBatchModule batch=new BBatchModule();
	    private static AProgramModule program=new AProgramModule();
	    Response response;
	    
	    @Given("User sets Authoization to {string} from batch")
	    public  void user_sets_authoization_to(String string) {
	    	batch.noAuthendication(string);
	    }
	  
	    
	@Given("User creates POST Request for the Batch LMS API endpoint")
	public void user_creates_post_request_for_the_batch_lms_api_endpoint() throws IOException {
		 prop=configreader.init_prop();	 
		  postURI=configreader.baseUrl()+configreader.endpointBatchSave();
		  System.out.println(postURI);
		  LoggerLoad.info("**************getting the end point for post**************" + postURI);
	}

	@When("User sends HTTPS Request for batch and  request Body with mandatory fields , additional using {string} and {int}")
	public void user_sends_https_request_for_batch_and_request_body_with_mandatory_additional_using_and(String string, Integer int1) throws InvalidFormatException, IOException {
		LoggerLoad.info("**************string value**************" + string);
		batch.getDatafromExcel(string, int1);
	   response= batch.postbatch(postURI);
	}

	@Then("User receives {int} Created Status with response body.")
	public void user_receives_created_status_with_response_body(Integer int1) {
		LoggerLoad.info("**************intvalue value**************" +int1);
	    Assert.assertEquals(201, int1);
	}
}
