package com.mastery.java.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;

@SpringBootTest
class SimplewebappApplicationTests {

	@LocalServerPort
	private int port;

	private String name = "java";

	@Autowired
	private TestRestTemplate restTemplate;

	private String postLocationUrl = "";

	private HttpHeaders headers;

	private final ObjectMapper objectMapper = new ObjectMapper();

	private JSONObject locationJsonObject;

	@Test
	void contextLoads() {
	}

}
