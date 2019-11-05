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
public class CreateSendSMSInput 
        extends java.util.Observable
        implements java.io.Serializable {
    private static final long serialVersionUID = 7323384775203991008L;
    private SendSMSRequest body;
    private String contentType;
    private String accept;
    /** GETTER
     * Message Body
     */
    @JsonGetter("Body")
    public SendSMSRequest getBody ( ) { 
        return this.body;
    }
    
    /** SETTER
     * Message Body
     */
    @JsonSetter("Body")
    public void setBody (SendSMSRequest value) { 
        this.body = value;
        notifyObservers(this.body);
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Content-Type")
    public String getContentType ( ) { 
        return this.contentType;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Content-Type")
    public void setContentType (String value) { 
        this.contentType = value;
        notifyObservers(this.contentType);
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Accept")
    public String getAccept ( ) { 
        return this.accept;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Accept")
    public void setAccept (String value) { 
        this.accept = value;
        notifyObservers(this.accept);
    }
 
}
