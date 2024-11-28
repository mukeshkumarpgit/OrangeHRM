package OrangeHRM.TestData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.*;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;

public class DataReader {

	public List<HashMap<String, String>> getDataJson(String filePath) throws IOException {

		// copy the jsondata from json to string

		String jsonData = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// converting the string to HashMap[collections]
		// we need to add jackson databind dependency

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonData,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}
}
