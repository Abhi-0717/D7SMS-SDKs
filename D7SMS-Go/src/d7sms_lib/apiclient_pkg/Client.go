/*
 * d7sms_lib
 *
 */

package apiclient_pkg


import(
	"github.com/apimatic/unirest-go"
	"d7sms_lib/apihelper_pkg"
	"d7sms_lib/configuration_pkg"
	"d7sms_lib/models_pkg"
)

/*
 * Input structure for the method CreateSendSMS
 */
type CreateSendSMSInput struct {
    Body            *models_pkg.SendSMSRequest //Message Body
    ContentType     string          //TODO: Write general description for this field
    Accept          string          //TODO: Write general description for this field
}

/*
 * Client structure as interface implementation
 */
type APICLIENT_IMPL struct {
     config configuration_pkg.CONFIGURATION
}

/**
 * Check account balance
 * @return	Returns the  response from the API call
 */
func (me *APICLIENT_IMPL) GetBalance () (error) {
    //the endpoint path uri
    _pathUrl := "/balance"

    //variable to hold errors
    var err error = nil
    //the base uri for api requests
    _queryBuilder := configuration_pkg.BASEURI;

    //prepare query string for API call
   _queryBuilder = _queryBuilder + _pathUrl

    //validate and preprocess url
    _queryBuilder, err = apihelper_pkg.CleanUrl(_queryBuilder)
    if err != nil {
        //error in url validation or cleaning
        return err
    }
    //prepare headers for the outgoing request
    headers := map[string]interface{} {
        "user-agent" : "D7SDK 1.0",
    }

    //prepare API request
    _request := unirest.GetWithAuth(_queryBuilder, headers, me.config.APIUsername(), me.config.APIPassword())
    //and invoke the API call request to fetch the response
    _response, err := unirest.AsString(_request,false);
    if err != nil {
        //error in API invocation
        return err
    }

    //error handling using HTTP status codes
    if (_response.Code == 500) {
        err = apihelper_pkg.NewAPIError("Internal Server Error", _response.Code, _response.RawBody)
    } else if (_response.Code < 200) || (_response.Code > 206) { //[200,206] = HTTP OK
            err = apihelper_pkg.NewAPIError("HTTP Response Not OK", _response.Code, _response.RawBody)
    }
    if(err != nil) {
        //error detected in status code validation
        return err
    }

    //returning the response
    return nil

}

/**
 * Send SMS  to recipients using D7 SMS Gateway
 * @param  CreateSendSMSInput     Structure with all inputs
 * @return	Returns the  response from the API call
 */
func (me *APICLIENT_IMPL) CreateSendSMS (input *CreateSendSMSInput) (error) {
    //the endpoint path uri
    _pathUrl := "/send"

    //variable to hold errors
    var err error = nil
    //the base uri for api requests
    _queryBuilder := configuration_pkg.BASEURI;

    //prepare query string for API call
   _queryBuilder = _queryBuilder + _pathUrl

    //validate and preprocess url
    _queryBuilder, err = apihelper_pkg.CleanUrl(_queryBuilder)
    if err != nil {
        //error in url validation or cleaning
        return err
    }
    //prepare headers for the outgoing request
    headers := map[string]interface{} {
        "user-agent" : "D7SDK 1.0",
        "content-type" : "application/json; charset=utf-8",
        "Content-Type" : apihelper_pkg.ToString(input.ContentType, ""),
        "Accept" : apihelper_pkg.ToString(input.Accept, ""),
    }

    //prepare API request
    _request := unirest.PostWithAuth(_queryBuilder, headers, input.Body, me.config.APIUsername(), me.config.APIPassword())
    //and invoke the API call request to fetch the response
    _response, err := unirest.AsString(_request,false);
    if err != nil {
        //error in API invocation
        return err
    }

    //error handling using HTTP status codes
    if (_response.Code == 500) {
        err = apihelper_pkg.NewAPIError("Internal Server Error", _response.Code, _response.RawBody)
    } else if (_response.Code < 200) || (_response.Code > 206) { //[200,206] = HTTP OK
            err = apihelper_pkg.NewAPIError("HTTP Response Not OK", _response.Code, _response.RawBody)
    }
    if(err != nil) {
        //error detected in status code validation
        return err
    }

    //returning the response
    return nil

}

/**
 * Send Bulk SMS  to multiple recipients using D7 SMS Gateway
 * @param    *models_pkg.BulkSMSRequest        body             parameter: Required
 * @param    string                            contentType      parameter: Required
 * @param    string                            accept           parameter: Required
 * @return	Returns the  response from the API call
 */
func (me *APICLIENT_IMPL) CreateBulkSMS (
            body *models_pkg.BulkSMSRequest,
            contentType string,
            accept string) (error) {
    //the endpoint path uri
    _pathUrl := "/sendbatch"

    //variable to hold errors
    var err error = nil
    //the base uri for api requests
    _queryBuilder := configuration_pkg.BASEURI;

    //prepare query string for API call
   _queryBuilder = _queryBuilder + _pathUrl

    //validate and preprocess url
    _queryBuilder, err = apihelper_pkg.CleanUrl(_queryBuilder)
    if err != nil {
        //error in url validation or cleaning
        return err
    }
    //prepare headers for the outgoing request
    headers := map[string]interface{} {
        "user-agent" : "D7SDK 1.0",
        "content-type" : "application/json; charset=utf-8",
        "Content-Type" : apihelper_pkg.ToString(contentType, ""),
        "Accept" : apihelper_pkg.ToString(accept, ""),
    }

    //prepare API request
    _request := unirest.PostWithAuth(_queryBuilder, headers, body, me.config.APIUsername(), me.config.APIPassword())
    //and invoke the API call request to fetch the response
    _response, err := unirest.AsString(_request,false);
    if err != nil {
        //error in API invocation
        return err
    }

    //error handling using HTTP status codes
    if (_response.Code < 200) || (_response.Code > 206) { //[200,206] = HTTP OK
        err = apihelper_pkg.NewAPIError("HTTP Response Not OK" , _response.Code, _response.RawBody)
    }
    if(err != nil) {
        //error detected in status code validation
        return err
    }

    //returning the response
    return nil

}

