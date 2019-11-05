# Getting started

D7 SMS allows you to reach your customers via SMS over D7's own connectivity to global mobile networks. D7 provides reliable and cost-effective SMS services to businesses across all industries and aims to connect all countries and territories via direct connections.

## How to Build


The generated code has dependencies over external libraries like UniRest. These dependencies are defined in the ```PodFile``` file that comes with the SDK. 
To resolve these dependencies, we use the Cocoapods package manager.
Visit https://guides.cocoapods.org/using/getting-started.html to setup Cocoapods on your system.
Open command prompt and type ```pod --version```. This should display the current version of Cocoapods installed if the installation was successful.

Using command line, navigate to the directory containing the generated files (including ```PodFile```) for the SDK. 
Run the command ```pod install```. This should install all the required dependencies and create the ```pods``` directory in your project directory.

![Installing dependencies using Cocoapods](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_1.svg)

Open the project workspace using the (D7SMS.xcworkspace) file. Invoke the build process using `Command(⌘)+B` shortcut key or using the `Build` menu as shown below.

![Building SDK using Xcode](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_2.svg)


## How to Use

The generated code is a Cocoa Touch Static Library which can be used in any iOS project. The support for these generated libraries go all the way back to iOS 6.

The following section explains how to use the D7SMS library in a new iOS project.     
### 1. Starting a new project
To start a new project, left-click on the ```Create a new Xcode project```.
![Create Test Project - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_3.svg)

Next, choose **Single View Application** and click ```Next```.
![Create Test Project - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_4.svg)

Provide **Test-Project** as the product name click ```Next```.
![Create Test Project - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_5.svg)

Choose the desired location of your project folder and click ```Create```.
![Create Test Project - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_6.svg)

### 2. Adding the static library dependency
To add this dependency open a terminal and navigate to your project folder. Next, input ```pod init``` and press enter.
![Add dependency - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_7.svg)

Next, open the newly created ```PodFile``` in your favourite text editor. Add the following line : pod 'D7SMS', :path => 'Vendor/D7SMS'
![Add dependency - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_8.svg)

Execute `pod install` from terminal to install the dependecy in your project. This would add the dependency to the newly created test project.
![Add dependency - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_9.svg)


## How to Test

Unit tests in this SDK can be run using Xcode. 

First build the SDK as shown in the steps above and naivgate to the project directory and open the D7SMS.xcworkspace file.

Go to the test explorer in Xcode as shown in the picture below and click on `run tests` from the menu. 
![Run tests](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/objc_10.svg)


## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| aPIUsername | API Key |
| aPIPassword | API Token |



Configuration variables can be set as following.
```Objc
// Configuration parameters and credentials
Configuration_APIUsername = "Configuration_APIUsername"; // API Key
Configuration_APIPassword = "Configuration_APIPassword"; // API Token

```

# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [APIController](#api_controller)

## <a name="api_controller"></a>![Class: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/class.png ".APIController") APIController

### Get singleton instance
```objc
Client* client = [[Client alloc]init] ;
```

### <a name="get_balance_with_completion_block"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/method.png ".APIController.getBalanceWithCompletionBlock") getBalanceWithCompletionBlock

> Check account balance


```objc
function getBalanceWithCompletionBlock:(CompletedGetBalance) onCompleted()
```



#### Example Usage

```objc

    [self.client getBalanceWithCompletionBlock:  ^(BOOL success, HttpContext* context, NSError* error) { 
       //Add code here
    }];
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |



### <a name="create_send_sms_async_with_create_send_sms_input"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/method.png ".APIController.createSendSMSAsyncWithCreateSendSMSInput") createSendSMSAsyncWithCreateSendSMSInput

> Send SMS  to recipients using D7 SMS Gateway


```objc
function createSendSMSAsyncWithCreateSendSMSInput:(CreateSendSMSInput*) input
                completionBlock:(CompletedPostSendSMS) onCompleted(input)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |





#### Example Usage

```objc
    // Parameters for the API call
    CreateSendSMSInput *input = [[CreateSendSMSInput alloc]init];
    input.body = [[SendSMSRequest alloc]init];
    input.contentType = @"Content-Type";
    input.accept = @"Accept";

    [self.client createSendSMSAsyncWithCreateSendSMSInput: input completionBlock:^(BOOL success, HttpContext* context, NSError* error) { 
       //Add code here
    }];
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |



### <a name="create_bulk_sms_async_with_body"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-IOS/images/method.png ".APIController.createBulkSMSAsyncWithBody") createBulkSMSAsyncWithBody

> Send Bulk SMS  to multiple recipients using D7 SMS Gateway


```objc
function createBulkSMSAsyncWithBody:(BulkSMSRequest*) body
                contentType:(NSString*) contentType
                accept:(NSString*) accept
                completionBlock:(CompletedPostBulkSMS) onCompleted(body contentType : contentType accept : accept)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |





#### Example Usage

```objc
    // Parameters for the API call
    BulkSMSRequest* body = (BulkSMSRequest*) [APIHelper jsonDeserialize: @"{  \"messages\": [    {      \"to\": [        \"971562316353\",        \"971562316354\",        \"971562316355\"      ],      \"content\": \"Same content goes to three numbers\",      \"from\": \"SignSMS\"    }  ]}"
                toClass: BulkSMSRequest.class];
    NSString* contentType = @"application/json";
    NSString* accept = @"application/json";

    [self.client createBulkSMSAsyncWithBody: body contentType : contentType accept : accept  completionBlock:^(BOOL success, HttpContext* context, NSError* error) { 
       //Add code here
    }];
```


[Back to List of Controllers](#list_of_controllers)



