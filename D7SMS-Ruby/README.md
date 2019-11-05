# Getting started

D7 SMS allows you to reach your customers via SMS over D7's own connectivity to global mobile networks. D7 provides reliable and cost-effective SMS services to businesses across all industries and aims to connect all countries and territories via direct connections.

## How to Build

This client library is a Ruby gem which can be compiled and used in your Ruby and Ruby on Rails project. This library requires a few gems from the RubyGems repository.

1. Open the command line interface or the terminal and navigate to the folder containing the source code.
2. Run ``` gem build d_7_sms.gemspec ``` to build the gem.
3. Once built, the gem can be installed on the current work environment using ``` gem install d_7_sms-1.0.0.gem ```

![Building Gem](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_1.svg)

## How to Use

The following section explains how to use the D7Sms Ruby Gem in a new Rails project using RubyMine&trade;. The basic workflow presented here is also applicable if you prefer using a different editor or IDE.

### 1. Starting a new project

Close any existing projects in RubyMine&trade; by selecting ``` File -> Close Project ```. Next, click on ``` Create New Project ``` to create a new project from scratch.

![Create a new project in RubyMine](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_2.svg)

Next, provide ``` TestApp ``` as the project name, choose ``` Rails Application ``` as the project type, and click ``` OK ```.

![Create a new Rails Application in RubyMine - step 1](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_3.svg)

In the next dialog make sure that correct *Ruby SDK* is being used (minimum 2.0.0) and click ``` OK ```.

![Create a new Rails Application in RubyMine - step 2](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_4.svg)

This will create a new Rails Application project with an existing set of files and folder.

### 2. Add reference of the gem

In order to use the D7Sms gem in the new project we must add a gem reference. Locate the ```Gemfile``` in the *Project Explorer* window under the ``` TestApp ``` project node. The file contains references to all gems being used in the project. Here, add the reference to the library gem by adding the following line: ``` gem 'd_7_sms', '~> 1.0.0' ```

![Add references of the Gemfile](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_5.svg)

### 3. Adding a new Rails Controller

Once the ``` TestApp ``` project is created, a folder named ``` controllers ``` will be visible in the *Project Explorer* under the following path: ``` TestApp > app > controllers ```. Right click on this folder and select ``` New -> Run Rails Generator... ```.

![Run Rails Generator on Controllers Folder](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_6.svg)

Selecting the said option will popup a small window where the generator names are displayed. Here, select the ``` controller ``` template.

![Create a new Controller](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_7.svg)

Next, a popup window will ask you for a Controller name and included Actions. For controller name provide ``` Hello ``` and include an action named ``` Index ``` and click ``` OK ```.

![Add a new Controller](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_8.svg)

A new controller class anmed ``` HelloController ``` will be created in a file named ``` hello_controller.rb ``` containing a method named ``` Index ```. In this method, add code for initialization and a sample for its usage.

![Initialize the library](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_9.svg)

## How to Test

You can test the generated SDK and the server with automatically generated test
cases as follows:

  1. From terminal/cmd navigate to the root directory of the SDK.
  2. Invoke: `bundle exec rake`

## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| api_username | API Key |
| api_password | API Token |



API client can be initialized as following.

```ruby
# Configuration parameters and credentials
api_username = 'api_username' # API Key
api_password = 'api_password' # API Token

client = D7Sms::D7SmsClient.new(
  api_username: api_username,
  api_password: api_password
)
```

The added initlization code can be debugged by putting a breakpoint in the ``` Index ``` method and running the project in debug mode by selecting ``` Run -> Debug 'Development: TestApp' ```.

![Debug the TestApp](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/ruby_10.svg)



# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [APIController](#api_controller)

## <a name="api_controller"></a>![Class: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/class.png ".APIController") APIController

### Get singleton instance

The singleton instance of the ``` APIController ``` class can be accessed from the API Client.

```ruby
client_controller = client.client
```

### <a name="get_balance"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/method.png ".APIController.get_balance") get_balance

> Check account balance


```ruby
def get_balance; end
```

#### Example Usage

```ruby

client_controller.get_balance()

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 500 | Internal Server Error |



### <a name="create_send_sms"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/method.png ".APIController.create_send_sms") create_send_sms

> Send SMS  to recipients using D7 SMS Gateway


```ruby
def create_send_sms(options = {}); end
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| content_type |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```ruby
collect = Hash.new

body = SendSMSRequest.new
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



### <a name="create_bulk_sms"></a>![Method: ](https://github.com/d7networks/D7SMS-SDKs/blob/master/D7SMS-Ruby/images/method.png ".APIController.create_bulk_sms") create_bulk_sms

> Send Bulk SMS  to multiple recipients using D7 SMS Gateway


```ruby
def create_bulk_sms(body,
                        content_type,
                        accept); end
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Message Body |
| content_type |  ``` Required ```  | TODO: Add a parameter description |
| accept |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```ruby
body_value = "{  \"messages\": [    {      \"to\": [        \"971562316353\",        \"971562316354\",        \"971562316355\"      ],      \"content\": \"Same content goes to three numbers\",      \"from\": \"SignSMS\"    }  ]}";
body = JSON.parse(body_value);
content_type = 'application/json'
accept = 'application/json'

client_controller.create_bulk_sms(body, content_type, accept)

```


[Back to List of Controllers](#list_of_controllers)



