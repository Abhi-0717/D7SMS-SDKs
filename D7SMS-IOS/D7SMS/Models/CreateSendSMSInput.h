//
//  D7SMS
//
//
#ifndef APIMATIC_CREATESENDSMSINPUT
#define APIMATIC_CREATESENDSMSINPUT

#import <Foundation/Foundation.h>
#import "JSONModel.h"
#import "APIHelper.h"

#import "SendSMSRequest.h"


//protocol defined for deserialization of JSON
@protocol CreateSendSMSInput
@end

@interface CreateSendSMSInput : NSObject

/**
* Message Body
*/
@property SendSMSRequest* body;

/**
* TODO: Write general description for this field
*/
@property NSString* contentType;

/**
* TODO: Write general description for this field
*/
@property NSString* accept;

@end
#endif