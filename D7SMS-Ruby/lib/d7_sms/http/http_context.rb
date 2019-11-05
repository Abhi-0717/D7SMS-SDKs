# d7_sms
#
# https://d7networks.com ).

module D7Sms
  # Represents an Http call in context.
  class HttpContext
    attr_accessor :request, :response

    # The constructor.
    # @param [HttpRequest] An HttpRequest object representing the HTTP request.
    # @param [HttpResponse] An HttpResponse object representing the HTTP
    # response.
    def initialize(request, response)
      @request = request
      @response = response
    end
  end
end
