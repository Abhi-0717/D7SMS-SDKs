/*
 * D7SMSLib
 *
 */
package com.d7networks.restapi.models;

import java.util.*;

public class CreateSendSMSInputBuilder {
    //the instance to build
    private CreateSendSMSInput createSendSMSInput;

    /**
     * Default constructor to initialize the instance
     */
    public CreateSendSMSInputBuilder() {
        createSendSMSInput = new CreateSendSMSInput();
    }

    /**
     * Message Body
     */
    public CreateSendSMSInputBuilder body(SendSMSRequest body) {
        createSendSMSInput.setBody(body);
        return this;
    }

    public CreateSendSMSInputBuilder contentType(String contentType) {
        createSendSMSInput.setContentType(contentType);
        return this;
    }

    public CreateSendSMSInputBuilder accept(String accept) {
        createSendSMSInput.setAccept(accept);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CreateSendSMSInput build() {
        return createSendSMSInput;
    }
}