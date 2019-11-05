//
//  D7SMS
//
//
#import "SendSMSRequest.h"

@implementation SendSMSRequest

/**
* Destination Mobile Number
*/
@synthesize to;

/**
* Sender ID / Number
*/
@synthesize from;

/**
* Message Content
*/
@synthesize content;



/**
* Key mappings for the json serialization and deserialization
*/
+(NSDictionary*) keyMap
{
    NSMutableDictionary* map = [[NSMutableDictionary alloc] init];
    [map addEntriesFromDictionary: @{
        @"to": @"to",
        @"from": @"from",
        @"content": @"content"  
    }];

    return map;
}

/**
* Key mapper for json serialization and deserialization
*/
+(JSONKeyMapper*) keyMapper
{ 
  return [[JSONKeyMapper alloc] initWithDictionary: [self keyMap]];
}

/**
* Helps avoiding deserialization errors when one or more properties are missing
* @returns	True, indicating that all properties are optional for deserialization
*/
+(BOOL)propertyIsOptional:(NSString*) propertyName
{
    return YES;
}

@end