# Getting started

D7 SMS allows you to reach your customers via SMS over D7's own connectivity to global mobile networks. D7 provides reliable and cost-effective SMS services to businesses across all industries and aims to connect all countries and territories via direct connections.

## How to Build

The generated SDK relies on [Node Package Manager](https://www.npmjs.com/) (NPM) being available to resolve dependencies. If you don't already have NPM installed, please go ahead and follow instructions to install NPM from [here](https://nodejs.org/en/download/).
The SDK also requires Node to be installed. If Node isn't already installed, please install it from [here](https://nodejs.org/en/download/)
> NPM is installed by default when Node is installed

To check if node and npm have been successfully installed, write the following commands in command prompt:

* `node --version`
* `npm -version`

![Version Check](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/nodejs_1.svg)

Now use npm to resolve all dependencies by running the following command in the root directory (of the SDK folder):

```bash
npm install
```

![Resolve Dependencies](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/nodejs_2.svg)

![Resolve Dependencies](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/nodejs_3.svg)

This will install all dependencies in the `node_modules` folder.

Once dependencies are resolved, you will need to move the folder `D7SMSLib ` in to your `node_modules` folder.

## How to Use

The following section explains how to use the library in a new project.

### 1. Open Project Folder
Open an IDE/Text Editor for JavaScript like Sublime Text. The basic workflow presented here is also applicable if you prefer using a different editor or IDE.

Click on `File` and select `Open Folder`.

![Open Folder](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/nodejs_4.svg)

Select the folder of your SDK and click on `Select Folder` to open it up in Sublime Text. The folder will become visible in the bar on the left.

![Open Project](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/nodejs_5.svg)

### 2. Creating a Test File

Now right click on the folder name and select the `New File` option to create a new test file. Save it as `index.js` Now import the generated NodeJS library using the following lines of code:

```js
var lib = require('lib');
```

Save changes.

![Create new file](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/nodejs_6.svg)

![Save new file](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/nodejs_7.svg)

### 3. Running The Test File

To run the `index.js` file, open up the command prompt and navigate to the Path where the SDK folder resides. Type the following command to run the file:

```
node index.js
```

![Run file](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/nodejs_8.svg)


## How to Test

These tests use Mocha framework for testing, coupled with Chai for assertions. These dependencies need to be installed for tests to run.
Tests can be run in a number of ways:

### Method 1 (Run all tests)

1. Navigate to the root directory of the SDK folder from command prompt.
2. Type `mocha --recursive` to run all the tests.

### Method 2 (Run all tests)

1. Navigate to the `../test/Controllers/` directory from command prompt.
2. Type `mocha *` to run all the tests.

### Method 3 (Run specific controller's tests)

1. Navigate to the `../test/Controllers/` directory from command prompt.
2. Type `mocha  D7SMSController`  to run all the tests in that controller file.

> To increase mocha's default timeout, you can change the `TEST_TIMEOUT` parameter's value in `TestBootstrap.js`.

![Run Tests](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/nodejs_9.svg)

## Initialization

### Authentication
In order to setup authentication in the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| aPIUsername | API Key |
| aPIPassword | API Token |



API client can be initialized as following:

```JavaScript
const lib = require('lib');

// Configuration parameters and credentials
lib.Configuration.aPIUsername = "aPIUsername"; // API Key
lib.Configuration.aPIPassword = "aPIPassword"; // API Token

```



# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [APIController](#api_controller)

## <a name="api_controller"></a>![Class: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/class.png ".APIController") APIController

### Get singleton instance

The singleton instance of the ``` APIController ``` class can be accessed from the API Client.

```javascript
var controller = lib.APIController;
```

### <a name="get_balance"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/method.png ".APIController.getBalance") getBalance

> Check account balance


```javascript
function getBalance(callback)
```

#### Example Usage

```javascript


    controller.getBalance(function(error, response, context) {

    
    });
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |




### <a name="create_send_sms"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/method.png ".APIController.createSendSMS") createSendSMS

> Send SMS  to recipients using D7 SMS Gateway


```javascript
function createSendSMS(input, callback)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |



#### Example Usage

```javascript

    var input = [];
        input['body'] = new SendSMSRequest({"key":"value"});
        input['contentType'] = 'Content-Type';
        input['accept'] = 'Accept';

    controller.createSendSMS(input, function(error, response, context) {

    
    });
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |




### <a name="create_bulk_sms"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-NodeJs/images/method.png ".APIController.createBulkSMS") createBulkSMS

> Send Bulk SMS  to multiple recipients using D7 SMS Gateway


```javascript
function createBulkSMS(body, contentType, accept, callback)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |



#### Example Usage

```javascript

    var body = new BulkSMSRequest({  "messages": [    {      "to": [        "971562316353",        "971562316354",        "971562316355"      ],      "content": "Same content goes to three numbers",      "from": "SignSMS"    }  ]});
    var contentType = 'application/json';
    var accept = 'application/json';

    controller.createBulkSMS(body, contentType, accept, function(error, response, context) {

    
    });
```



[Back to List of Controllers](#list_of_controllers)



