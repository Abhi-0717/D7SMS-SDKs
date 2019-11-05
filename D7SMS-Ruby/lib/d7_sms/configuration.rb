# d7_sms
#
# https://d7networks.com ).

# CohesityManagementSdk
module D7Sms
  # All configuration including auth info and base URI for the API access
  # are configured in this class.
  class Configuration
    # The base Uri for API calls
    @base_uri = 'https://rest-api.d7networks.com/secure'

    # API Key
    @api_username = 'TODO: Replace'

    # API Token
    @api_password = 'TODO: Replace'

    # The attribute accessors for public properties.
    class << self
      attr_accessor :array_serialization
      attr_accessor :base_uri
      attr_accessor :api_username
      attr_accessor :api_password
    end
  end
end
