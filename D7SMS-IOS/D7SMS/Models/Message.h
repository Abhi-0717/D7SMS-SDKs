//
//  D7SMS
//
//
#ifndef APIMATIC_MESSAGE
#define APIMATIC_MESSAGE

#import <Foundation/Foundation.h>
#import "JSONModel.h"
#import "APIHelper.h"



//protocol defined for deserialization of JSON
@protocol Message
@end

@interface Message : JSONModel

/**
* Destination Number
*/
@property NSArray* to;

/**
* TODO: Write general description for this field
*/
@property NSString* content;

/**
* TODO: Write general description for this field
*/
@property NSString* from;


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