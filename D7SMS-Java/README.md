# Getting started

D7 SMS allows you to reach your customers via SMS over D7's own connectivity to global mobile networks. D7 provides reliable and cost-effective SMS services to businesses across all industries and aims to connect all countries and territories via direct connections.

## How to Build

The generated code uses a few Maven dependencies e.g., Jackson, UniRest,
and Apache HttpClient. The reference to these dependencies is already
added in the pom.xml file will be installed automatically. Therefore,
you will need internet access for a successful build.

* In order to open the client library in Eclipse click on ``` File -> Import ```.

![Importing SDK into Eclipse - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_1.svg)

* In the import dialog, select ``` Existing Java Project ``` and click ``` Next ```.

![Importing SDK into Eclipse - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_2.svg)

* Browse to locate the folder containing the source code. Select the detected location of the project and click ``` Finish ```.

![Importing SDK into Eclipse - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_3.svg)

* Upon successful import, the project will be automatically built by Eclipse after automatically resolving the dependencies.

![Importing SDK into Eclipse - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_4.svg)

## How to Use

The following section explains how to use the D7SMS library in a new console project.

### 1. Starting a new project

For starting a new project, click the menu command ``` File > New > Project ```.

![Add a new project in Eclipse](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_5.svg)

Next, choose ``` Maven > Maven Project ```and click ``` Next ```.

![Create a new Maven Project - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_6.svg)

Here, make sure to use the current workspace by choosing ``` Use default Workspace location ```, as shown in the picture below and click ``` Next ```.

![Create a new Maven Project - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_7.svg)

Following this, select the *quick start* project type to create a simple project with an existing class and a ``` main ``` method. To do this, choose ``` maven-archetype-quickstart ``` item from the list and click ``` Next ```.

![Create a new Maven Project - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_8.svg)

In the last step, provide a ``` Group Id ``` and ``` Artifact Id ``` as shown in the picture below and click ``` Finish ```.

![Create a new Maven Project - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_9.svg)

### 2. Add reference of the library project

The created Maven project manages its dependencies using its ``` pom.xml ``` file. In order to add a dependency on the *D7SMSLib* client library, double click on the ``` pom.xml ``` file in the ``` Package Explorer ```. Opening the ``` pom.xml ``` file will render a graphical view on the cavas. Here, switch to the ``` Dependencies ``` tab and click the ``` Add ``` button as shown in the picture below.

![Adding dependency to the client library - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_10.svg)

Clicking the ``` Add ``` button will open a dialog where you need to specify D7SMS in ``` Group Id ``` and D7SMSLib in the ``` Artifact Id ``` fields. Once added click ``` OK ```. Save the ``` pom.xml ``` file.

![Adding dependency to the client library - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_11.svg)

### 3. Write sample code

Once the ``` SimpleConsoleApp ``` is created, a file named ``` App.java ``` will be visible in the *Package Explorer* with a ``` main ``` method. This is the entry point for the execution of the created project.
Here, you can add code to initialize the client library and instantiate a *Controller* class. Sample code to initialize the client library and using controller methods is given in the subsequent sections.

![Adding dependency to the client library - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/java_12.svg)

## How to Test

The generated code and the server can be tested using automatically generated test cases. 
JUnit is used as the testing framework and test runner.

In Eclipse, for running the tests do the following:

1. Select the project *D7SMSLib* from the package explorer.
2. Select "Run -> Run as -> JUnit Test" or use "Alt + Shift + X" followed by "T" to run the Tests.

## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| aPIUsername | API Key |
| aPIPassword | API Token |



API client can be initialized as following.

```java
// Configuration parameters and credentials
String aPIUsername = "aPIUsername"; // API Key
String aPIPassword = "aPIPassword"; // API Token

D7SMSClient client = new D7SMSClient(aPIUsername, aPIPassword);
```


# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [APIController](#api_controller)

## <a name="api_controller"></a>![Class: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/class.png "com.d7networks.restapi.controllers.APIController") APIController

### Get singleton instance

The singleton instance of the ``` APIController ``` class can be accessed from the API Client.

```java
APIController client = client.getClient();
```

### <a name="get_balance_async"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/method.png "com.d7networks.restapi.controllers.APIController.getBalanceAsync") getBalanceAsync

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



### <a name="create_send_sms_async"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/method.png "com.d7networks.restapi.controllers.APIController.createSendSMSAsync") createSendSMSAsync

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



### <a name="create_bulk_sms_async"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Java/images/method.png "com.d7networks.restapi.controllers.APIController.createBulkSMSAsync") createBulkSMSAsync

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



