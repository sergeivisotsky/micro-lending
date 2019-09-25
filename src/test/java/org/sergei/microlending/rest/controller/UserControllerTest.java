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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


/**
 * @author Sergei Visotsky
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test that all users returned correctly
     * {@link UserController#getAllUsers()}
     *
     * @throws JSONException ex
     */
    @Test
    public void getAllUsersTest() throws JSONException {
        String getResourceUrl = "http://localhost:" + port + "/getallusers";
        ResponseEntity<String> response = restTemplate.exchange(getResourceUrl, HttpMethod.GET, null, String.class);
        String expected = TestUtils.readFromJSONFile("json/all_users.json");
        String actual = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.STRICT);
    }

    /**
     * Test that user which has returned by ID is correct
     * {@link UserController#getUserById(Long)}
     *
     * @throws JSONException ex
     */
    @Test
    public void getUserByIdTest() throws JSONException {
        String getResourceUrl = "http://localhost:" + port + "/getuserbyid/2";
        ResponseEntity<String> response = restTemplate.exchange(getResourceUrl, HttpMethod.GET, null, String.class);
        String expected = TestUtils.readFromJSONFile("json/second_user.json");
        String actual = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.STRICT);
    }
}
