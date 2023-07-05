package Testng;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datareader {

	@SuppressWarnings("deprecation")
	public List<HashMap<String, String>> Reader() throws IOException {

		// read json to string
		String entire = FileUtils.readFileToString(
				new File(
						"C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\src\\test\\java\\Testng\\purchase.json"),
				StandardCharsets.UTF_8);

		// String to Hashmap

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(entire,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

}
