//
//  D7SMS
//
//
#import "JSONValueTransformer+NSDate.h"
#import "NSDate+extension.h"
@implementation JSONValueTransformer (NSDate)

-(NSDate*) NSDateFromNSString:(NSString*)string
{
    return [NSDate NSDateFromNSString:string];
}

@end
