package utilities;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Properties;
import java.util.List;


public class PageUtils {
	static Properties prop;
	public static String[] getProgramFieldsfromExcel(String sheetname, int rownumber) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		ExcelReader reader = new ExcelReader();
		String arrayinput[]=new String[3];
		System.out.println(sheetname + rownumber);
		System.out.println(Config_Reader.excelpath());
		List<Map<String, String>> testdata = reader.getData(Config_Reader.excelpath(), sheetname);
		String programdescription = testdata.get(rownumber).get("programDescription");	
		String programname=testdata.get(rownumber).get("programName");
		String programstatus=testdata.get(rownumber).get("programStatus");
		System.out.println("inside excel");
		arrayinput[0]=programdescription;
		arrayinput[1]=programname;
		arrayinput[2]=programstatus;
		return arrayinput;			

	}
	
	public static String duedate() {

		LocalDateTime Time = LocalDateTime.now().plusDays(10);
		String date = String.valueOf(Time);
		return date;
	}
}
