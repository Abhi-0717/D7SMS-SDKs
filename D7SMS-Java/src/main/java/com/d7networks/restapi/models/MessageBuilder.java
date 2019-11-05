/*
 * D7SMSLib
 *
 */
package com.d7networks.restapi.models;

import java.util.*;

public class MessageBuilder {
    //the instance to build
    private Message message;

    /**
     * Default constructor to initialize the instance
     */
    public MessageBuilder() {
        message = new Message();
    }

    /**
     * Destination Number
     */
    public MessageBuilder to(List<String> to) {
        message.setTo(to);
        return this;
    }

    public MessageBuilder content(String content) {
        message.setContent(content);
        return this;
    }

    public MessageBuilder from(String from) {
        message.setFrom(from);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Message build() {
        return message;
    }
}