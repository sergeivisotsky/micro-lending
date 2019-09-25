package org.sergei.microlending.rest.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sergei.microlending.utils.TestUtils;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergei Visotsky
 */
@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class LoanControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getLoansForUserTest() throws JSONException {
        String getResourceUrl = "http://localhost:" + port + "/getloansforuser?userId=1";
        ResponseEntity<String> response = restTemplate.exchange(getResourceUrl, HttpMethod.GET, null, String.class);
        String expected = TestUtils.readFromJSONFile("json/all_loans_for_user.json");
        String actual = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.STRICT);
    }

    @Test
    public void saveLoanForUser() {
        String getResourceUrl = "http://localhost:" + port + "/saveloanforuser";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> request = new HttpEntity<>(TestUtils.readFromJSONFile("json/loan_request.json"), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(getResourceUrl, request, String.class);
        String expected = TestUtils.readFromJSONFile("json/all_loans_for_user.json");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
