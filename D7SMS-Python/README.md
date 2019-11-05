# Getting started

D7 SMS allows you to reach your customers via SMS over D7's own connectivity to global mobile networks. D7 provides reliable and cost-effective SMS services to businesses across all industries and aims to connect all countries and territories via direct connections.

## How to Build


You must have Python ```2 >=2.7.9``` or Python ```3 >=3.4``` installed on your system to install and run this SDK. This SDK package depends on other Python packages like nose, jsonpickle etc. 
These dependencies are defined in the ```requirements.txt``` file that comes with the SDK.
To resolve these dependencies, you can use the PIP Dependency manager. Install it by following steps at [https://pip.pypa.io/en/stable/installing/](https://pip.pypa.io/en/stable/installing/).

Python and PIP executables should be defined in your PATH. Open command prompt and type ```pip --version```.
This should display the version of the PIP Dependency Manager installed if your installation was successful and the paths are properly defined.

* Using command line, navigate to the directory containing the generated files (including ```requirements.txt```) for the SDK.
* Run the command ```pip install -r requirements.txt```. This should install all the required dependencies.

![Building SDK - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_1.svg)


## How to Use

The following section explains how to use the D7sms SDK package in a new project.

### 1. Open Project in an IDE

Open up a Python IDE like PyCharm. The basic workflow presented here is also applicable if you prefer using a different editor or IDE.

![Open project in PyCharm - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_2.svg)

Click on ```Open``` in PyCharm to browse to your generated SDK directory and then click ```OK```.

![Open project in PyCharm - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_3.svg)     

The project files will be displayed in the side bar as follows:

![Open project in PyCharm - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_4.svg)     

### 2. Add a new Test Project

Create a new directory by right clicking on the solution name as shown below:

![Add a new project in PyCharm - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_5.svg)

Name the directory as "test"

![Add a new project in PyCharm - Step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_6.svg)
   
Add a python file to this project with the name "testsdk"

![Add a new project in PyCharm - Step 3](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_7.svg)

Name it "testsdk"

![Add a new project in PyCharm - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_8.svg)

In your python file you will be required to import the generated python library using the following code lines

```Python
from d7sms.d_7_sms_client import D7smsClient
```

![Add a new project in PyCharm - Step 4](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_9.svg)

After this you can write code to instantiate an API client object, get a controller object and  make API calls. Sample code is given in the subsequent sections.

### 3. Run the Test Project

To run the file within your test project, right click on your Python file inside your Test project and click on ```Run```

![Run Test Project - Step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/python_10.svg)


## How to Test

You can test the generated SDK and the server with automatically generated test
cases. unittest is used as the testing framework and nose is used as the test
runner. You can run the tests as follows:

  1. From terminal/cmd navigate to the root directory of the SDK.
  2. Invoke ```pip install -r test-requirements.txt```
  3. Invoke ```nosetests```

## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| api_username | API Key |
| api_password | API Token |



API client can be initialized as following.

```python
# Configuration parameters and credentials
api_username = 'api_username' # API Key
api_password = 'api_password' # API Token

client = D7smsClient(api_username, api_password)
```



# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [APIController](#api_controller)

## <a name="api_controller"></a>![Class: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/class.png ".APIController") APIController

### Get controller instance

An instance of the ``` APIController ``` class can be accessed from the API Client.

```python
 client_controller = client.client
```

### <a name="get_balance"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/method.png ".APIController.get_balance") get_balance

> Check account balance

```python
def get_balance(self)
```

#### Example Usage

```python

client_controller.get_balance()

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |




### <a name="create_send_sms"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/method.png ".APIController.create_send_sms") create_send_sms

> Send SMS  to recipients using D7 SMS Gateway

```python
def create_send_sms(self,
                        options=dict())
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |



#### Example Usage

```python
collect = {}

body = SendSMSRequest()
collect['body'] = body

content_type = 'Content-Type'
collect['content_type'] = content_type

accept = 'Accept'
collect['accept'] = accept


client_controller.create_send_sms(collect)

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |




### <a name="create_bulk_sms"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Python/images/method.png ".APIController.create_bulk_sms") create_bulk_sms

> Send Bulk SMS  to multiple recipients using D7 SMS Gateway

```python
def create_bulk_sms(self,
                        body,
                        content_type,
                        accept)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| contentType |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |



#### Example Usage

```python
body_value = "{  \"messages\": [    {      \"to\": [        \"971562316353\",        \"971562316354\",        \"971562316355\"      ],      \"content\": \"Same content goes to three numbers\",      \"from\": \"SignSMS\"    }  ]}"
body = json.loads(body_value)
content_type = 'application/json'
accept = 'application/json'

client_controller.create_bulk_sms(body, content_type, accept)

```


[Back to List of Controllers](#list_of_controllers)



