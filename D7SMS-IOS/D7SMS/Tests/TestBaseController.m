//
//  D7SMS
//
//
#import <XCTest/XCTest.h>
#import "TestHelper.h"
#import "Configuration.h"
#import "TestBaseController.h"

@implementation  TestBaseController : XCTestCase

//Precision constant for decimal comparisons
static const double assertPrecision = 0.01;

//Timeout constant for specifying timeout interval
static const NSTimeInterval timeOut = 30;

//Setup test class
//This method is called before the invocation of each test method in the test class
- (void)setUp {
    [super setUp];
    
}

//Teardown test class
//This method is called after the invocation of each test method in the test class
- (void)tearDown {
    [super tearDown];
}

//Timeout handler function
//Wait function specifies the timeout for the test 
- (void) wait{
    [self waitForExpectationsWithTimeout:[TestBaseController timeOut] handler:^(NSError *error) {
        if (error) {
            NSLog(@"Timeout Error: %@", error);
        }
    }];
}

//Assert precision getter function
//Returns the precision of decimal point comparisons
+ (double)assertPrecision
{
    return assertPrecision;
}

//Timeout class getter function
//Returns the number of seconds beofre the test times out
+ (NSTimeInterval)timeOut
{
    return timeOut;
}

@end
