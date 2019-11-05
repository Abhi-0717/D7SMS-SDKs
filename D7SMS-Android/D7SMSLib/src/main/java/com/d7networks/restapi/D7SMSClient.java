/*
 * D7SMSLib
 *
 */
package com.d7networks.restapi;

import com.d7networks.restapi.controllers.*;
import com.d7networks.restapi.http.client.HttpClient;

public class D7SMSClient {
    /**
     * Singleton access to Client controller
     * @return	Returns the APIController instance 
     */
    public APIController getClient() {
        return APIController.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Default constructor 
     */     
    public D7SMSClient() {
    }

    /**
     * Client initialization constructor 
     */     
    public D7SMSClient(String aPIUsername, String aPIPassword) {
        this();
        Configuration.aPIUsername = aPIUsername;
        Configuration.aPIPassword = aPIPassword;
    }
}