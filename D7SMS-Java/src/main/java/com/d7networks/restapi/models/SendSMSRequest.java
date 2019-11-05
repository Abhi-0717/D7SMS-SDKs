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
public class SendSMSRequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 6017378064551352941L;
    private long to;
    private String from;
    private String content;
    /** GETTER
     * Destination Mobile Number
     */
    @JsonGetter("to")
    public long getTo ( ) { 
        return this.to;
    }
    
    /** SETTER
     * Destination Mobile Number
     */
    @JsonSetter("to")
    public void setTo (long value) { 
        this.to = value;
    }
 
    /** GETTER
     * Sender ID / Number
     */
    @JsonGetter("from")
    public String getFrom ( ) { 
        return this.from;
    }
    
    /** SETTER
     * Sender ID / Number
     */
    @JsonSetter("from")
    public void setFrom (String value) { 
        this.from = value;
    }
 
    /** GETTER
     * Message Content
     */
    @JsonGetter("content")
    public String getContent ( ) { 
        return this.content;
    }
    
    /** SETTER
     * Message Content
     */
    @JsonSetter("content")
    public void setContent (String value) { 
        this.content = value;
    }
 
}
