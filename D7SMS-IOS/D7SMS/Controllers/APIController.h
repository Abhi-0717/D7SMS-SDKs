//
//  D7SMS
//
//
#import <Foundation/Foundation.h>
#import "Configuration.h"
#import "APIHelper.h"
#import "APIError.h"
#import "BaseController.h"
#import "UnirestClient.h"
#import "HttpContext.h"
#import "SendSMSRequest.h"
#import "CreateSendSMSInput.h"
#import "BulkSMSRequest.h"

@interface APIController : BaseController

/**
* Completion block definition for asynchronous call to Balance */
typedef void (^CompletedGetBalance)(BOOL success, HttpContext* context, NSError* error);

/**
* Check account balance
*/
- (void) getBalanceWithCompletionBlock:(CompletedGetBalance) onCompleted;

/**
* Completion block definition for asynchronous call to SendSMS */
typedef void (^CompletedPostSendSMS)(BOOL success, HttpContext* context, NSError* error);

/**
* Send SMS  to recipients using D7 SMS Gateway
* @param  CreateSendSMSInput     Object with all parameters
*/
- (void) createSendSMSAsyncWithCreateSendSMSInput:(CreateSendSMSInput*) input
                completionBlock:(CompletedPostSendSMS) onCompleted;

/**
* Completion block definition for asynchronous call to Bulk SMS */
typedef void (^CompletedPostBulkSMS)(BOOL success, HttpContext* context, NSError* error);

/**
* Send Bulk SMS  to multiple recipients using D7 SMS Gateway
* @param    body    Required parameter: Message Body
* @param    contentType    Required parameter: Example: 
* @param    accept    Required parameter: Example: 
*/
- (void) createBulkSMSAsyncWithBody:(BulkSMSRequest*) body
                contentType:(NSString*) contentType
                accept:(NSString*) accept
                completionBlock:(CompletedPostBulkSMS) onCompleted;

@end