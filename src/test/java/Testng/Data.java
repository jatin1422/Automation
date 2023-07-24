package Testng;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Data {
	
	public List<HashMap<String,String>> main() throws IOException {
		
	
		  String entire  = FileUtils.readFileToString(new File("C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\src\\test\\java\\Testng\\purchase.json"), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
        List<HashMap<String,String>> data = mapper.readValue(entire, new  TypeReference<List<HashMap<String,String>>>(){
        });
		
        return data;
		
	}

}
