//
//  D7SMS
//
//
#ifndef APIMATIC_BULKSMSREQUEST
#define APIMATIC_BULKSMSREQUEST

#import <Foundation/Foundation.h>
#import "JSONModel.h"
#import "APIHelper.h"

#import "Message.h"


//protocol defined for deserialization of JSON
@protocol BulkSMSRequest
@end

@interface BulkSMSRequest : JSONModel

/**
* Sendbatch message body
*/
@property NSArray<Message> * messages;


/**
* Key mappings for the json serialization and deserialization
*/
+(NSDictionary*) keyMap;

/**
* Key mapper for json serialization and deserialization
*/
+(JSONKeyMapper*) keyMapper;

/**
* Helps avoiding deserialization errors when one or more properties are missing
* @returns	True, indicating that all properties are optional for deserialization
*/
+(BOOL)propertyIsOptional:(NSString*) propertyName;

@end
#endif