# d7_sms
#
# https://d7networks.com ).

module D7Sms
  #  d7_sms client class.
  class D7SmsClient
    # Singleton access to client controller.
    # @return [APIController] Returns the controller instance.
    def client
      APIController.instance
    end

    # Returns the configuration class for easy access.
    # @return [Configuration] Returns the actual configuration class.
    def config
      Configuration
    end

    # Initializer with authentication and configuration parameters.
    def initialize(api_username: nil, api_password: nil)
      Configuration.api_username = api_username if
        api_username
      Configuration.api_password = api_password if
        api_password
    end
  end
end
