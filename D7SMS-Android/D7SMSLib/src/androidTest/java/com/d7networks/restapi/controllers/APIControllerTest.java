/*
 * D7SMSLib
 *
 */
package com.d7networks.restapi.controllers;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.d7networks.restapi.models.*;
import com.d7networks.restapi.exceptions.*;
import com.d7networks.restapi.APIHelper;
import com.d7networks.restapi.Configuration;
import com.d7networks.restapi.testing.TestHelper;
import com.d7networks.restapi.controllers.APIController;
import com.d7networks.restapi.controllers.syncwrapper.APICallBackCatcher;

import com.fasterxml.jackson.core.type.TypeReference;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class APIControllerTest extends ControllerTestBase {
    
    /**
     * Controller instance (for all tests)
     */
    private static APIController controller;
    
    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        controller = getClient().getClient();
    }

    /**
     * Tear down test class
     * @throws IOException
     */
    @AfterClass
    public static void tearDownClass() throws IOException {
        controller = null;
    }

    /**
     * Check Balance
     * @throws Throwable
     */
    @Test
    public void testBalance() throws Throwable {

        // Set callback and perform API call
        APICallBackCatcher<Object> response = new APICallBackCatcher<Object>();
        controller.setHttpCallBack(httpResponse);
        controller.getBalanceAsync(response);
        response.getResult();

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 500", 
                500, httpResponse.getResponse().getStatusCode());

    }

    /**
     * Send SMS  to a recipient using D7 SMS Gateway
     * @throws Throwable
     */
    @Test
    public void testSendSMS() throws Throwable {
        // Parameters for the API call
        CreateSendSMSInput input = new CreateSendSMSInput();
        input.setBody(APIHelper.deserialize("{  \"to\": 971562316353,  \"from\": \"SignSMS\",  \"content\": \"Send single SMS Testing\"}", new TypeReference<SendSMSRequest>(){}));
        input.setContentType("application/json");
        input.setAccept("application/json");

        // Set callback and perform API call
        APICallBackCatcher<Object> response = new APICallBackCatcher<Object>();
        controller.setHttpCallBack(httpResponse);
        controller.createSendSMSAsync(input, response);
        response.getResult();

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 500", 
                500, httpResponse.getResponse().getStatusCode());

    }

    /**
     * Send SMS  to multiple recipients using D7 SMS Gateway
     * @throws Throwable
     */
    @Test
    public void testBulkSMS() throws Throwable {
        // Parameters for the API call
        BulkSMSRequest body = APIHelper.deserialize("{  \"messages\": [    {      \"to\": [        \"971562316353\",        \"971562316354\",        \"971562316355\"      ],      \"content\": \"Same content goes to three numbers\",      \"from\": \"SignSMS\"    }  ]}", new TypeReference<BulkSMSRequest>(){});
        String contentType = "application/json";
        String accept = "application/json";

        // Set callback and perform API call
        APICallBackCatcher<Object> response = new APICallBackCatcher<Object>();
        controller.setHttpCallBack(httpResponse);
        controller.createBulkSMSAsync(body, contentType, accept, response);
        response.getResult();

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 500", 
                500, httpResponse.getResponse().getStatusCode());

    }

}
