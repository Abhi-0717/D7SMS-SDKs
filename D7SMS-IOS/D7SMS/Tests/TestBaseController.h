//
//  D7SMS
//
//
@interface  TestBaseController : XCTestCase

//Assert precision getter function
//Returns the precision of decimal point comparisons
+ (double)assertPrecision;

//Timeout class getter function
//Returns the number of seconds beofre the test times out
+ (NSTimeInterval)timeOut;

//Setup test class
//This method is called before the invocation of each test method in the test class
- (void)setUp ;

//Teardown test class
//This method is called after the invocation of each test method in the test class
- (void)tearDown ; 
 
//Timeout handler function
//Wait function specifies the timeout for the test 
- (void) wait;

@end

