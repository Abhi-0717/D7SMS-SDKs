/*
 * D7SMSLib
 *
 */
package com.d7networks.restapi.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.d7networks.restapi.*;
import com.d7networks.restapi.models.*;
import com.d7networks.restapi.exceptions.*;
import com.d7networks.restapi.http.client.HttpClient;
import com.d7networks.restapi.http.client.HttpContext;
import com.d7networks.restapi.http.request.HttpRequest;
import com.d7networks.restapi.http.response.HttpResponse;
import com.d7networks.restapi.http.response.HttpStringResponse;
import com.d7networks.restapi.http.client.APICallBack;

public class APIController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static APIController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the APIController class 
     */
    public static APIController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new APIController();
                }
            }
        }
        return instance;
    }

    /**
     * Check account balance
     * @return    Returns the void response from the API call 
     */
    public void getBalanceAsync(
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetBalanceRequest();
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleGetBalanceResponse(_context);
                            callBack.onSuccess(_context, null);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for getBalance
     */
    private HttpRequest _buildGetBalanceRequest() throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/balance");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null,
                Configuration.aPIUsername, Configuration.aPIPassword);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for getBalance
     * @return An object of type void
     */
    private void _handleGetBalanceResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 500) {
            throw new APIException("Internal Server Error", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);


    }

    /**
     * Send SMS  to recipients using D7 SMS Gateway
     * @param    CreateSendSMSInput    Object containing request parameters
     * @return    Returns the void response from the API call 
     */
    public void createSendSMSAsync(
                final CreateSendSMSInput input,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateSendSMSRequest(input);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleCreateSendSMSResponse(_context);
                            callBack.onSuccess(_context, null);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for createSendSMS
     */
    private HttpRequest _buildCreateSendSMSRequest(
                final CreateSendSMSInput input) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/send");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Content-Type", input.getContentType());
        _headers.put("Accept", input.getAccept());
        _headers.put("user-agent", BaseController.userAgent);


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(input.getBody()),
                Configuration.aPIUsername, Configuration.aPIPassword);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for createSendSMS
     * @return An object of type void
     */
    private void _handleCreateSendSMSResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 500) {
            throw new APIException("Internal Server Error", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);


    }

    /**
     * Send Bulk SMS  to multiple recipients using D7 SMS Gateway
     * @param    body    Required parameter: Message Body
     * @param    contentType    Required parameter: Example: 
     * @param    accept    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void createBulkSMSAsync(
                final BulkSMSRequest body,
                final String contentType,
                final String accept,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateBulkSMSRequest(body, contentType, accept);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleCreateBulkSMSResponse(_context);
                            callBack.onSuccess(_context, null);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for createBulkSMS
     */
    private HttpRequest _buildCreateBulkSMSRequest(
                final BulkSMSRequest body,
                final String contentType,
                final String accept) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/sendbatch");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Content-Type", contentType);
        _headers.put("Accept", accept);
        _headers.put("user-agent", BaseController.userAgent);


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(body),
                Configuration.aPIUsername, Configuration.aPIPassword);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for createBulkSMS
     * @return An object of type void
     */
    private void _handleCreateBulkSMSResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);


    }

}
