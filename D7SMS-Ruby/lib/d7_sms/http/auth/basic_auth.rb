# d7_sms
#
# https://d7networks.com ).

require 'base64'

module D7Sms
  # Utility class for basic authorization.
  class BasicAuth
    # Add basic authentication to the request.
    # @param [HttpRequest] The HttpRequest object to which authentication will
    # be added.
    def self.apply(http_request)
      username = Configuration.api_username
      password = Configuration.api_password
      value = Base64.strict_encode64("#{username}:#{password}")
      header_value = "Basic #{value}"
      http_request.headers['Authorization'] = header_value
    end
  end
end
