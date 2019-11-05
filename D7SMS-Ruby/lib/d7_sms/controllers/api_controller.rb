# d7_sms
#
# https://d7networks.com ).

module D7Sms
  # APIController
  class APIController < BaseController
    @instance = APIController.new

    class << self
      attr_accessor :instance
    end

    def instance
      self.class.instance
    end

    # Check account balance
    # @return void response from the API call
    def get_balance
      # Prepare query url.
      _path_url = '/balance'
      _query_builder = Configuration.base_uri.dup
      _query_builder << _path_url
      _query_url = APIHelper.clean_url _query_builder
      # Prepare and execute HttpRequest.
      _request = @http_client.get(
        _query_url
      )
      BasicAuth.apply(_request)
      _context = execute_request(_request)
      # Validate response against endpoint and global error codes.
      if _context.response.status_code == 500
        raise APIException.new(
          'Internal Server Error',
          _context
        )
      end
      validate_response(_context)
    end

    # Send SMS  to recipients using D7 SMS Gateway
    # @param [SendSMSRequest] body Required parameter: Message Body
    # @param [String] content_type Required parameter: Example:
    # @param [String] accept Required parameter: Example:
    # @return void response from the API call
    def create_send_sms(options = {})
      # Prepare query url.
      _path_url = '/send'
      _query_builder = Configuration.base_uri.dup
      _query_builder << _path_url
      _query_url = APIHelper.clean_url _query_builder
      # Prepare headers.
      _headers = {
        'Content-Type' => options['content_type'],
        'Accept' => options['accept']
      }
      # Prepare and execute HttpRequest.
      _request = @http_client.post(
        _query_url,
        headers: _headers,
        parameters: options['body'].to_json
      )
      BasicAuth.apply(_request)
      _context = execute_request(_request)
      # Validate response against endpoint and global error codes.
      if _context.response.status_code == 500
        raise APIException.new(
          'Internal Server Error',
          _context
        )
      end
      validate_response(_context)
    end

    # Send Bulk SMS  to multiple recipients using D7 SMS Gateway
    # @param [BulkSMSRequest] body Required parameter: Message Body
    # @param [String] content_type Required parameter: Example:
    # @param [String] accept Required parameter: Example:
    # @return void response from the API call
    def create_bulk_sms(body,
                        content_type,
                        accept)
      # Prepare query url.
      _path_url = '/sendbatch'
      _query_builder = Configuration.base_uri.dup
      _query_builder << _path_url
      _query_url = APIHelper.clean_url _query_builder
      # Prepare headers.
      _headers = {
        'Content-Type' => content_type,
        'Accept' => accept
      }
      # Prepare and execute HttpRequest.
      _request = @http_client.post(
        _query_url,
        headers: _headers,
        parameters: body.to_json
      )
      BasicAuth.apply(_request)
      _context = execute_request(_request)
      validate_response(_context)
    end
  end
end
