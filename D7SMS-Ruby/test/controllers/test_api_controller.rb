# d7_sms
#
# https://d7networks.com ).

require_relative 'controller_test_base'

class APIControllerTests < ControllerTestBase
  # Called only once for the class before any test has executed
  def self.startup
    self.controller = @@api_client.client
  end

  # Check Balance
  def test_balance()

    # Perform the API call through the SDK function
    assert_raise('APIException'){ 
      self.class.controller.get_balance()
    }

    # Test response code
    assert_equal(@response_catcher.response.status_code, 500)
  end

  # Send SMS  to a recipient using D7 SMS Gateway
  def test_send_sms()
    # Parameters for the API call
    options = {}
    options['body'] = SendSMSRequest.from_hash(JSON.parse('{"to":971562316353,"from":"SignSMS","content":"Send single SMS Testing"}'))
    options['content_type'] = 'application/json'
    options['accept'] = 'application/json'

    # Perform the API call through the SDK function
    assert_raise('APIException'){ 
      self.class.controller.create_send_sms(options)
    }

    # Test response code
    assert_equal(@response_catcher.response.status_code, 500)
  end

  # Send SMS  to multiple recipients using D7 SMS Gateway
  def test_bulk_sms()
    # Parameters for the API call
    body = BulkSMSRequest.from_hash(JSON.parse(
      '{"messages":[{"to":["971562316353","971562316354","971562316355"],"content'\
      '":"Same content goes to three numbers","from":"SignSMS"}]}'
      ))
    content_type = 'application/json'
    accept = 'application/json'

    # Perform the API call through the SDK function
    assert_raise('APIException'){ 
      self.class.controller.create_bulk_sms(body, content_type, accept)
    }

    # Test response code
    assert_equal(@response_catcher.response.status_code, 500)
  end

end
