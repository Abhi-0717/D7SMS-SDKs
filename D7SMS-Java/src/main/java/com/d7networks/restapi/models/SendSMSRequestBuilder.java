/*
 * D7SMSLib
 *
 */
package com.d7networks.restapi.models;

import java.util.*;

public class SendSMSRequestBuilder {
    //the instance to build
    private SendSMSRequest sendSMSRequest;

    /**
     * Default constructor to initialize the instance
     */
    public SendSMSRequestBuilder() {
        sendSMSRequest = new SendSMSRequest();
    }

    /**
     * Destination Mobile Number
     */
    public SendSMSRequestBuilder to(long to) {
        sendSMSRequest.setTo(to);
        return this;
    }

    /**
     * Sender ID / Number
     */
    public SendSMSRequestBuilder from(String from) {
        sendSMSRequest.setFrom(from);
        return this;
    }

    /**
     * Message Content
     */
    public SendSMSRequestBuilder content(String content) {
        sendSMSRequest.setContent(content);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SendSMSRequest build() {
        return sendSMSRequest;
    }
}