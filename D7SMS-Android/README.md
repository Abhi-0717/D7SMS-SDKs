# Getting started

D7 SMS allows you to reach your customers via SMS over D7's own connectivity to global mobile networks. D7 provides reliable and cost-effective SMS services to businesses across all industries and aims to connect all countries and territories via direct connections.

## How to Build

The generated code uses a few Gradle dependencies e.g., Jackson, Volley,
and Apache HttpClient. The reference to these dependencies is already
added in the build.gradle file will be installed automatically. Therefore,
you will need internet access for a successful build.

* In order to open the client library in Android Studio click on ``` Open an Existing Android Project ```.

![Importing SDK into Android Studio - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_1.svg)

* Browse to locate the folder containing the source code. Select the location of the D7SMS gradle project and click ``` Ok ```.

![Importing SDK into Android Studio - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_2.svg)

* Upon successful import, the project can be built by clicking on ``` Build > Make Project ``` or  pressing ``` Ctrl + F9 ```.

![Importing SDK into Android Studio - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_3.svg)

## How to Use

The following section explains how to use the D7SMS library in a new project.

### 1. Starting a new project 

For starting a new project, click on ``` Create New Android Studio Project ```.

![Add a new project in Android Studio - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_4.svg)

Here, configure the new project by adding the name, domain and location of the sample application followed by clicking ``` Next ```.

![Create a new Android Studio Project - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_5.svg)

Following this, select the `Phone and Tablet` option as shown in the illustration below and click `Next`.

![Create a new Android Studio Project - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_6.svg)

In the following step, choose ``` Empty Activity ``` as the activity type and click ``` Next ```.

![Create a new Android Studio Project - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_7.svg)

In this step, provide an ``` Activity Name ``` and ``` Layout Name ``` and click ``` Finish ```.  This would take you to the newly created project.

![Create a new Android Studio Project - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_8.svg)

### 2. Add reference of the library project

In order to add a dependency to this sample application, click on the android button shown in the project explorer on the left side as shown in the picture. Click on ``` Project ``` in the drop down that emerges.  

![Adding dependency to the client library - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_9.svg)

Right click the sample application in the project explorer and click on ``` New > Module ```  as shown in the picture.

![Adding dependency to the client library - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_10.svg)

Choose ``` Import Gradle Project ``` and click ``` Next ```.

![Adding dependency to the client library - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_11.svg)

Click on ``` Finish ``` which would take you back to the sample application with the refernced SDK. 

![Adding dependency to the client library - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_12.svg)

In the following step first navigate to the ``` SampleApplication > settings.gradle ``` file and add the line
```include ':D7SMSLib'```

Then navigate to the ``` SampleApplication >  app > build.gradle ``` file and add the following line 
```implementation project(path: ':D7SMSLib')```
to the dependencies section as shown in the illustration below. Also add the following packagingOptions.

packagingOptions
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/NOTICE'
    exclude 'META-INF/DEPENDENCIES'
}

![Adding dependency to the client library - Step 5](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_13.svg)

Finally, press ``` Sync Now ``` in the warning visible as shown in the picture below.

![Adding dependency to the client library - Step 6](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/android_14.svg)

### 3. Write sample code

Once the ``` SampleApplication ``` is created, a file named ``` SampleApplication > app > src > main > java > MainActivity ``` will be visible in the *Project Explorer* with an ``` onCreate ``` method. This is the entry point for the execution of the created project.
Here, you can add code to initialize the client library and instantiate a *Controller* class. Sample code to initialize the client library and using controller methods is given in the subsequent sections.

## How to Test

The generated code and the server can be tested using automatically generated test cases. 
JUnit is used as the testing framework and test runner.

In Android Studio, for running the tests do the following:

1. Right click on *SampleApplication > D7SMSLib > androidTest > java)* from the project explorer.
2. Select "Run All Tests" or use "Ctrl + Shift + F10" to run the Tests.

## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| aPIUsername | API Key |
| aPIPassword | API Token |



API client can be initialized as following. The `appContext` being passed is the Android application [`Context`](https://developer.android.com/reference/android/content/Context.html).

```java
// Configuration parameters and credentials
String aPIUsername = "aPIUsername"; // API Key
String aPIPassword = "aPIPassword"; // API Token

com.d7networks.restapi.Configuration.initialize(appContext);
D7SMSClient client = new D7SMSClient(aPIUsername, aPIPassword);
```


# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [APIController](#api_controller)

## <a name="api_controller"></a>![Class: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/class.png "com.d7networks.restapi.controllers.APIController") APIController

### Get singleton instance

The singleton instance of the ``` APIController ``` class can be accessed from the API Client.

```java
APIController client = client.getClient();
```

### <a name="get_balance_async"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/method.png "com.d7networks.restapi.controllers.APIController.getBalanceAsync") getBalanceAsync

> Check account balance


```java
void getBalanceAsync(final APICallBack<Object> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
client.getBalanceAsync(new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |



### <a name="create_send_sms_async"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/class.png "com.d7networks.restapi.controllers.APIController.createSendSMSAsync") createSendSMSAsync

> Send SMS  to recipients using D7 SMS Gateway


```java
void createSendSMSAsync(
        final CreateSendSMSInput input,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
CreateSendSMSInput collect = new CreateSendSMSInput();

    SendSMSRequest body = new SendSMSRequest();
collect.setBody(body);

    String contentType = "Content-Type";
collect.setContentType(contentType);

    String accept = "Accept";
collect.setAccept(accept);

    // Invoking the API call with sample inputs
    client.createSendSMSAsync(collect, new APICallBack<void>() {
        public void onSuccess(HttpContext context, void response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    }
);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |



### <a name="create_bulk_sms_async"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Android/images/class.png "com.d7networks.restapi.controllers.APIController.createBulkSMSAsync") createBulkSMSAsync

> Send Bulk SMS  to multiple recipients using D7 SMS Gateway


```java
void createBulkSMSAsync(
        final BulkSMSRequest body,
        final String contentType,
        final String accept,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String bodyValue = "{  \"messages\": [    {      \"to\": [        \"971562316353\",        \"971562316354\",        \"971562316355\"      ],      \"content\": \"Same content goes to three numbers\",      \"from\": \"SignSMS\"    }  ]}";
    BulkSMSRequest body = mapper.readValue(bodyValue,new TypeReference<BulkSMSRequest> (){});
    String contentType = "application/json";
    String accept = "application/json";
    // Invoking the API call with sample inputs
    client.createBulkSMSAsync(body, contentType, accept, new APICallBack<void>() {
        public void onSuccess(HttpContext context, void response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


[Back to List of Controllers](#list_of_controllers)



