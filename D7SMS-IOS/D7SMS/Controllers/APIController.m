//
//  D7SMS
//
//
#import "APIController.h"

@implementation APIController

/**
* Check account balance
* @return	Returns the void response from the API call */
- (void) getBalanceWithCompletionBlock:(CompletedGetBalance) onCompleted
{
    //the base uri for api requests
    NSString* _baseUri = [NSString stringWithString: (NSString*) Configuration_BaseUri];

    //prepare query string for API call
    NSMutableString* _queryBuilder = [NSMutableString stringWithString: _baseUri]; 
    [_queryBuilder appendString: @"/balance"];

    //validate and preprocess url
    NSString* _queryUrl = [APIHelper cleanUrl: _queryBuilder];

    //preparing request headers
    NSMutableDictionary* _headers = [[NSMutableDictionary alloc] initWithDictionary: @{
        @"user-agent": @"D7SDK 1.0"
    }];

    //Remove null values from header collection in order to omit from request
    [APIHelper removeNullValues: _headers];


    //prepare the request and fetch response  
    HttpRequest* _request = [[self clientInstance] get: ^(HttpRequest* _request) 
    { 
        [_request setQueryUrl: _queryUrl]; //set request url        
        [_request setHeaders: _headers]; //set request headers
        [_request setUsername: Configuration_APIUsername];
        [_request setPassword: Configuration_APIPassword];

    }];

    //use the instance of the http client to make the actual call
    [[self clientInstance]
     executeAsString: _request
     success: ^(id _context, HttpResponse *_response) {
         //Error handling using HTTP status codes
         NSError* _statusError = nil;

         //Error handling using HTTP status codes 
         if (_response.statusCode == 500)
             _statusError = [[APIError alloc] initWithReason: @"Internal Server Error"
                                               andContext:_context];
         else if((_response.statusCode < 200) || (_response.statusCode > 208)) //[200,208] = HTTP OK
             _statusError = [[APIError alloc] initWithReason: @"HTTP Response Not OK"
                                                  andContext:_context];

         if(_statusError != nil)
         {
             //announce completion with failure due to HTTP status code checking
             onCompleted(NO, _context, _statusError);
         }
         else
         {
             //return _response to API caller

             onCompleted(YES, _context, nil);
         }
     } failure:^(id _context, NSError *_error) {
 
         //announce completion with failure
         onCompleted(NO, _context, _error);
     }];
}

/**
* Send SMS  to recipients using D7 SMS Gateway
* @param  CreateSendSMSInput     Object with all parameters
* @return	Returns the void response from the API call */
- (void) createSendSMSAsyncWithCreateSendSMSInput:(CreateSendSMSInput*) input
                completionBlock:(CompletedPostSendSMS) onCompleted
{
    //the base uri for api requests
    NSString* _baseUri = [NSString stringWithString: (NSString*) Configuration_BaseUri];

    //prepare query string for API call
    NSMutableString* _queryBuilder = [NSMutableString stringWithString: _baseUri]; 
    [_queryBuilder appendString: @"/send"];

    //validate and preprocess url
    NSString* _queryUrl = [APIHelper cleanUrl: _queryBuilder];

    //preparing request headers
    NSMutableDictionary* _headers = [[NSMutableDictionary alloc] initWithDictionary: @{
        @"user-agent": @"D7SDK 1.0",
        @"content-type": @"application/json; charset=utf-8",
        @"Content-Type": input.contentType,
        @"Accept": input.accept
    }];

    //Remove null values from header collection in order to omit from request
    [APIHelper removeNullValues: _headers];


    //prepare the request and fetch response 
    HttpRequest* _request = [[self clientInstance] postBody: ^(HttpBodyRequest* _request)
    {
        [_request setBody: [[APIHelper jsonSerialize: input.body] dataUsingEncoding:NSUTF8StringEncoding]]; //set request body
        [_request setQueryUrl: _queryUrl]; //set request url        
        [_request setHeaders: _headers]; //set request headers
        [_request setUsername: Configuration_APIUsername];
        [_request setPassword: Configuration_APIPassword];

    }];

    //use the instance of the http client to make the actual call
    [[self clientInstance]
     executeAsString: _request
     success: ^(id _context, HttpResponse *_response) {
         //Error handling using HTTP status codes
         NSError* _statusError = nil;

         //Error handling using HTTP status codes 
         if (_response.statusCode == 500)
             _statusError = [[APIError alloc] initWithReason: @"Internal Server Error"
                                               andContext:_context];
         else if((_response.statusCode < 200) || (_response.statusCode > 208)) //[200,208] = HTTP OK
             _statusError = [[APIError alloc] initWithReason: @"HTTP Response Not OK"
                                                  andContext:_context];

         if(_statusError != nil)
         {
             //announce completion with failure due to HTTP status code checking
             onCompleted(NO, _context, _statusError);
         }
         else
         {
             //return _response to API caller

             onCompleted(YES, _context, nil);
         }
     } failure:^(id _context, NSError *_error) {
 
         //announce completion with failure
         onCompleted(NO, _context, _error);
     }];
}

/**
* Send Bulk SMS  to multiple recipients using D7 SMS Gateway
* @param    body    Required parameter: Message Body
* @param    contentType    Required parameter: Example: 
* @param    accept    Required parameter: Example: 
* @return	Returns the void response from the API call */
- (void) createBulkSMSAsyncWithBody:(BulkSMSRequest*) body
                contentType:(NSString*) contentType
                accept:(NSString*) accept
                completionBlock:(CompletedPostBulkSMS) onCompleted
{
    //the base uri for api requests
    NSString* _baseUri = [NSString stringWithString: (NSString*) Configuration_BaseUri];

    //prepare query string for API call
    NSMutableString* _queryBuilder = [NSMutableString stringWithString: _baseUri]; 
    [_queryBuilder appendString: @"/sendbatch"];

    //validate and preprocess url
    NSString* _queryUrl = [APIHelper cleanUrl: _queryBuilder];

    //preparing request headers
    NSMutableDictionary* _headers = [[NSMutableDictionary alloc] initWithDictionary: @{
        @"user-agent": @"D7SDK 1.0",
        @"content-type": @"application/json; charset=utf-8",
        @"Content-Type": contentType,
        @"Accept": accept
    }];

    //Remove null values from header collection in order to omit from request
    [APIHelper removeNullValues: _headers];


    //prepare the request and fetch response 
    HttpRequest* _request = [[self clientInstance] postBody: ^(HttpBodyRequest* _request)
    {
        [_request setBody: [[APIHelper jsonSerialize: body] dataUsingEncoding:NSUTF8StringEncoding]]; //set request body
        [_request setQueryUrl: _queryUrl]; //set request url        
        [_request setHeaders: _headers]; //set request headers
        [_request setUsername: Configuration_APIUsername];
        [_request setPassword: Configuration_APIPassword];

    }];

    //use the instance of the http client to make the actual call
    [[self clientInstance]
     executeAsString: _request
     success: ^(id _context, HttpResponse *_response) {
         //Error handling using HTTP status codes
         NSError* _statusError = nil;

         //Error handling using HTTP status codes 
         if((_response.statusCode < 200) || (_response.statusCode > 208)) //[200,208] = HTTP OK
             _statusError = [[APIError alloc] initWithReason: @"HTTP Response Not OK"
                                                  andContext:_context];

         if(_statusError != nil)
         {
             //announce completion with failure due to HTTP status code checking
             onCompleted(NO, _context, _statusError);
         }
         else
         {
             //return _response to API caller

             onCompleted(YES, _context, nil);
         }
     } failure:^(id _context, NSError *_error) {
 
         //announce completion with failure
         onCompleted(NO, _context, _error);
     }];
}


@end