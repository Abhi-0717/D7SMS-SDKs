/*
 * D7SMSLib
 *
 */
package com.d7networks.restapi.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

import com.d7networks.restapi.D7SMSClient;
import com.d7networks.restapi.Configuration;
import com.d7networks.restapi.testing.HttpCallBackCatcher;

/**
 * Base class for all test cases
 */
public class ControllerTestBase {
    /**
     * Test configuration
     */
    public final static int REQUEST_TIMEOUT = 30;

    public final static double ASSERT_PRECISION = 0.01;
    
    /**
     * Global rules for tests
     */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(REQUEST_TIMEOUT);
    
    /**
     * Test fixtures
     */
    
    // Used to serve as HttpCallBack and to capture request & response
    protected HttpCallBackCatcher httpResponse = new HttpCallBackCatcher();
    
    /**
     * Setup test
     */
    @Before
    public void setUp() throws Exception {
        httpResponse = new HttpCallBackCatcher(); 
    }

    /**
     * Tear down test
     */
    @After
    public void tearDown() throws Exception {
        if(httpResponse.getResponse() != null)
            httpResponse.getResponse().shutdown();
        httpResponse = null;
    }
    
    // Singleton instance of client for all test classes
    private static D7SMSClient client;
    private static final Object clientSync = new Object();
    
    /**
     * Get client instance
     * @return
     */
    protected static D7SMSClient getClient() {
        if (client == null) {
            synchronized (clientSync) {
                if (client == null) {
                    client = new D7SMSClient();
                }
            }
        }
        return client;
    }
}
