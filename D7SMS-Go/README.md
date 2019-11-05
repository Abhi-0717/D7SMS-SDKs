# Getting started

D7 SMS allows you to reach your customers via SMS over D7's own connectivity to global mobile networks. D7 provides reliable and cost-effective SMS services to businesses across all industries and aims to connect all countries and territories via direct connections.

## How to Build


* In order to successfully build and run your SDK files, you are required to have the following setup in your system:
    * **Go**  (Visit [https://golang.org/doc/install](https://golang.org/doc/install) for more details on how to install Go)
    * **Java VM** Version 8 or later
    * **Eclipse 4.6 (Neon)** or later ([http://www.eclipse.org/neon/](http://www.eclipse.org/neon/))
    * **GoClipse** setup within above installed Eclipse (Follow the instructions at [this link](https://github.com/GoClipse/goclipse/blob/latest/documentation/Installation.md#instructions) to setup GoClipse)
* Ensure that ```GOPATH``` environment variable is set in the system variables. If not, set it to your workspace directory where you will be adding your Go projects.
* The generated code uses unirest-go http library. Therefore, you will need internet access to resolve this dependency. If Go is properly installed and configured, run the following command to pull the dependency:

```Go
go get github.com/apimatic/unirest-go
```

This will install unirest-go in the ```GOPATH``` you specified in the system variables.

Now follow the steps mentioned below to build your SDK:

1. Open eclipse in the Go language perspective and click on the ```Import``` option in ```File``` menu.

![Importing SDK into Eclipse - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_1.svg)

2. Select ```General -> Existing Projects into Workspace``` option from the tree list.

![Importing SDK into Eclipse - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_2.svg)

3. In ```Select root directory```, provide path to the unzipped archive for the generated code. Once the path is set and the Project becomes visible under ```Projects``` click ```Finish```

![Importing SDK into Eclipse - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_3.svg)

4. The Go library will be imported and its files will be visible in the Project Explorer

![Importing SDK into Eclipse - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_4.svg)

## How to Use

The following section explains how to use the D7smsLib library in a new project.

### 1. Add a new Test Project

Create a new project in Eclipse by ```File``` -> ```New``` -> ```Go Project```

![Add a new project in Eclipse](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_5.svg)

Name the Project as ```Test``` and click ```Finish```

![Create a new Maven Project - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_6.svg)

Create a new directory in the ```src``` directory of this project

![Create a new Maven Project - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_7.svg)

Name it ```test.com```

![Create a new Maven Project - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_8.svg)

Now create a new file inside ```src/test.com```

![Create a new Maven Project - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_9.svg)

Name it ```testsdk.go```

![Create a new Maven Project - Step 5](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_10.svg)

In this Go file, you can start adding code to initialize the client library. Sample code to initialize the client library and using its methods is given in the subsequent sections.

### 2. Configure the Test Project

You need to import your generated library in this project in order to make use of its functions. In order to import the library, you can add its path in the ```GOPATH``` for this project. Follow the below steps:

Right click on the project name and click on ```Properties```

![Adding dependency to the client library - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_11.svg)

Choose ```Go Compiler``` from the side menu. Check ```Use project specific settings``` and uncheck ```Use same value as the GOPATH environment variable.```. By default, the GOPATH value from the environment variables will be visible in ```Eclipse GOPATH```. Do not remove this as this points to the unirest dependency.

![Adding dependency to the client library - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_12.svg)

Append the library path to this GOPATH

![Adding dependency to the client library - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_13.svg)

Once the path is appended, click on ```OK```

### 3. Build the Test Project

Right click on the project name and click on ```Build Project```

![Build Project](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_14.svg)

### 4. Run the Test Project

If the build is successful, right click on your Go file and click on ```Run As``` -> ```Go Application```

![Run Project](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/go_15.svg)

## Initialization

### Authentication
In order to setup authentication of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| aPIUsername | API Key |
| aPIPassword | API Token |


To configure these for your generated code, open the file "Configuration.go" and edit it's contents.


# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [api_pkg](#api_pkg)

## <a name="api_pkg"></a>![Class: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/class.png ".api_pkg") api_pkg

### Get instance

Factory for the ``` API ``` interface can be accessed from the package api_pkg.

```go
aPI := api_pkg.NewAPI()
```

### <a name="get_balance"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/method.png ".api_pkg.GetBalance") GetBalance

> Check account balance


```go
func (me *API_IMPL) GetBalance()(,error)
```

#### Example Usage

```go

var result 
result,_ = aPI.GetBalance()

```

#### Errors
 
| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |



### <a name="create_send_sms"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/method.png ".api_pkg.CreateSendSMS") CreateSendSMS

> Send SMS  to recipients using D7 SMS Gateway


```go
func (me *API_IMPL) CreateSendSMS(input *CreateSendSMSInput)(,error)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```go
collect := new (api_pkg.CreateSendSMSInput)

var body *models_pkg.SendSMSRequest
collect.Body = body

contentType := "Content-Type"
collect.ContentType = contentType

accept := "Accept"
collect.Accept = accept


var result 
result,_ = aPI.CreateSendSMS(collect)

```

#### Errors
 
| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |



### <a name="create_bulk_sms"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Go/images/method.png ".api_pkg.CreateBulkSMS") CreateBulkSMS

> Send Bulk SMS  to multiple recipients using D7 SMS Gateway


```go
func (me *API_IMPL) CreateBulkSMS(
            body *models_pkg.BulkSMSRequest,
            contentType string,
            accept string)(,error)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```go
bodyValue := []byte("{  \"messages\": [    {      \"to\": [        \"971562316353\",        \"971562316354\",        \"971562316355\"      ],      \"content\": \"Same content goes to three numbers\",      \"from\": \"SignSMS\"    }  ]}")
var body *models_pkg.BulkSMSRequest
json.Unmarshal(bodyValue,&body)
contentType := "application/json"
accept := "application/json"

var result 
result,_ = aPI.CreateBulkSMS(body, contentType, accept)

```


[Back to List of Controllers](#list_of_controllers)



