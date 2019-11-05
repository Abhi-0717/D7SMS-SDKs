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
public class Message 
        implements java.io.Serializable {
    private static final long serialVersionUID = 2458464809773257809L;
    private List<String> to;
    private String content;
    private String from;
    /** GETTER
     * Destination Number
     */
    @JsonGetter("to")
    public List<String> getTo ( ) { 
        return this.to;
    }
    
    /** SETTER
     * Destination Number
     */
    @JsonSetter("to")
    public void setTo (List<String> value) { 
        this.to = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("content")
    public String getContent ( ) { 
        return this.content;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("content")
    public void setContent (String value) { 
        this.content = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("from")
    public String getFrom ( ) { 
        return this.from;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("from")
    public void setFrom (String value) { 
        this.from = value;
    }
 
}
