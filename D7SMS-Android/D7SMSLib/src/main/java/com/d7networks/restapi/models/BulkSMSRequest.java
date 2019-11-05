/*
 * D7SMSLib
 *
 */
package com.d7networks.restapi.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class BulkSMSRequest 
        extends java.util.Observable
        implements java.io.Serializable {
    private static final long serialVersionUID = 126552347192072664L;
    private List<Message> messages;
    /** GETTER
     * Sendbatch message body
     */
    @JsonGetter("messages")
    public List<Message> getMessages ( ) { 
        return this.messages;
    }
    
    /** SETTER
     * Sendbatch message body
     */
    @JsonSetter("messages")
    public void setMessages (List<Message> value) { 
        this.messages = value;
        notifyObservers(this.messages);
    }
 
}
