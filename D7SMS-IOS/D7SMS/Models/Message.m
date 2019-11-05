//
//  D7SMS
//
//
#import "Message.h"

@implementation Message

/**
* Destination Number
*/
@synthesize to;

/**
* TODO: Write general description for this method
*/
@synthesize content;

/**
* TODO: Write general description for this method
*/
@synthesize from;



/**
* Key mappings for the json serialization and deserialization
*/
+(NSDictionary*) keyMap
{
    NSMutableDictionary* map = [[NSMutableDictionary alloc] init];
    [map addEntriesFromDictionary: @{
        @"to": @"to",
        @"content": @"content",
        @"from": @"from"  
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