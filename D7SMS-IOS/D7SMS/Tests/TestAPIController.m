//
//  D7SMS
//
//
#import <XCTest/XCTest.h>
#import "APIController.h"
#import "TestHelper.h"
#import "TestBaseController.h"

@interface  TestAPIController : TestBaseController
//Controller instance for all tests
@property APIController* controller;
@end 


@implementation  TestAPIController : TestBaseController

//Setup test class
//This method is called before the invocation of each test method in the test class
- (void)setUp {
    [super setUp];
    self.controller = [[APIController alloc]init];
}

//Teardown test class
//This method is called after the invocation of each test method in the test class
- (void)tearDown {
    [super tearDown];
}	


// Check Balance    
-(void) testBalance {
    //Set up test expectations
    XCTestExpectation *expectation =[self expectationWithDescription:@"High Expectations"];

    // Set callback and perform API call
    [self.controller getBalanceWithCompletionBlock:  ^(BOOL success, HttpContext* context, NSError* error) { 
       // Test response code
        XCTAssertEqual(500, context.response.statusCode);
        

        [expectation fulfill];
    }];
    [self wait];
}

// Send SMS  to a recipient using D7 SMS Gateway    
-(void) testSendSMS {
    //Set up test expectations
    XCTestExpectation *expectation =[self expectationWithDescription:@"High Expectations"];
    // Parameters for the API call
    CreateSendSMSInput *input = [[CreateSendSMSInput alloc]init];
    input.body = (SendSMSRequest*) [APIHelper jsonDeserialize: @"{  \"to\": 971562316353,  \"from\": \"SignSMS\",  \"content\": \"Send single SMS Testing\"}"
                toClass: SendSMSRequest.class];
    input.contentType = @"application/json";
    input.accept = @"application/json";

    // Set callback and perform API call
    [self.controller createSendSMSAsyncWithCreateSendSMSInput: input completionBlock:^(BOOL success, HttpContext* context, NSError* error) { 
       // Test response code
        XCTAssertEqual(500, context.response.statusCode);
        

        [expectation fulfill];
    }];
    [self wait];
}

// Send SMS  to multiple recipients using D7 SMS Gateway    
-(void) testBulkSMS {
    //Set up test expectations
    XCTestExpectation *expectation =[self expectationWithDescription:@"High Expectations"];
    // Parameters for the API call
    BulkSMSRequest* body = (BulkSMSRequest*) [APIHelper jsonDeserialize: @"{  \"messages\": [    {      \"to\": [        \"971562316353\",        \"971562316354\",        \"971562316355\"      ],      \"content\": \"Same content goes to three numbers\",      \"from\": \"SignSMS\"    }  ]}"
                toClass: BulkSMSRequest.class];
    NSString* contentType = @"application/json";
    NSString* accept = @"application/json";

    // Set callback and perform API call
    [self.controller createBulkSMSAsyncWithBody: body contentType : contentType accept : accept  completionBlock:^(BOOL success, HttpContext* context, NSError* error) { 
       // Test response code
        XCTAssertEqual(500, context.response.statusCode);
        

        [expectation fulfill];
    }];
    [self wait];
}



@end
