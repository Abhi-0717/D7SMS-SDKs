//
//  D7SMS
//
//
#ifndef APIMATIC_SENDSMSREQUEST
#define APIMATIC_SENDSMSREQUEST

#import <Foundation/Foundation.h>
#import "JSONModel.h"
#import "APIHelper.h"



//protocol defined for deserialization of JSON
@protocol SendSMSRequest
@end

@interface SendSMSRequest : JSONModel

/**
* Destination Mobile Number
*/
@property long to;

/**
* Sender ID / Number
*/
@property NSString* from;

/**
* Message Content
*/
@property NSString* content;


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