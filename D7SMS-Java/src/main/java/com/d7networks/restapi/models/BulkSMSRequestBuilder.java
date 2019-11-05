/*
 * D7SMSLib
 *
 */
package com.d7networks.restapi.models;

import java.util.*;

public class BulkSMSRequestBuilder {
    //the instance to build
    private BulkSMSRequest bulkSMSRequest;

    /**
     * Default constructor to initialize the instance
     */
    public BulkSMSRequestBuilder() {
        bulkSMSRequest = new BulkSMSRequest();
    }

    /**
     * Sendbatch message body
     */
    public BulkSMSRequestBuilder messages(List<Message> messages) {
        bulkSMSRequest.setMessages(messages);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public BulkSMSRequest build() {
        return bulkSMSRequest;
    }
}