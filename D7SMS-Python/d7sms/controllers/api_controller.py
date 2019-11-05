# -*- coding: utf-8 -*-

"""
    d7sms

"""

from d7sms.api_helper import APIHelper
from d7sms.configuration import Configuration
from d7sms.controllers.base_controller import BaseController
from d7sms.http.auth.basic_auth import BasicAuth
from d_7_sms.exceptions.api_exception import APIException

class APIController(BaseController):

    """A Controller to access Endpoints in the d7sms API."""


    def get_balance(self):
        """Does a GET request to /balance.

        Check account balance

        Returns:
            void: Response from the API. 

        Raises:
            APIException: When an error occurs while fetching the data from
                the remote API. This exception includes the HTTP Response
                code, an error message, and the HTTP body that was received in
                the request.

        """

        # Prepare query URL
        _url_path = '/balance'
        _query_builder = Configuration.base_uri
        _query_builder += _url_path
        _query_url = APIHelper.clean_url(_query_builder)

        # Prepare and execute request
        _request = self.http_client.get(_query_url)
        BasicAuth.apply(_request)
        _context = self.execute_request(_request)

        # Endpoint and global error handling using HTTP status codes.
        if _context.response.status_code == 500:
            raise APIException('Internal Server Error', _context)
        self.validate_response(_context)

    def create_send_sms(self,
                        options=dict()):
        """Does a POST request to /send.

        Send SMS  to recipients using D7 SMS Gateway

        Args:
            options (dict, optional): Key-value pairs for any of the
                parameters to this API Endpoint. All parameters to the
                endpoint are supplied through the dictionary with their names
                being the key and their desired values being the value. A list
                of parameters that can be used are::

                    body -- SendSMSRequest -- Message Body
                    content_type -- string -- TODO: type description here.
                        Example: 
                    accept -- string -- TODO: type description here. Example:
                        
        Returns:
            void: Response from the API. 

        Raises:
            APIException: When an error occurs while fetching the data from
                the remote API. This exception includes the HTTP Response
                code, an error message, and the HTTP body that was received in
                the request.

        """

        # Prepare query URL
        _url_path = '/send'
        _query_builder = Configuration.base_uri
        _query_builder += _url_path
        _query_url = APIHelper.clean_url(_query_builder)

        # Prepare headers
        _headers = {
            'Content-Type': options.get('content_type', None),
            'Accept': options.get('accept', None)
        }

        # Prepare and execute request
        _request = self.http_client.post(_query_url, headers=_headers, parameters=APIHelper.json_serialize(options.get('body')))
        BasicAuth.apply(_request)
        _context = self.execute_request(_request)

        # Endpoint and global error handling using HTTP status codes.
        if _context.response.status_code == 500:
            raise APIException('Internal Server Error', _context)
        self.validate_response(_context)

    def create_bulk_sms(self,
                        body,
                        content_type,
                        accept):
        """Does a POST request to /sendbatch.

        Send Bulk SMS  to multiple recipients using D7 SMS Gateway

        Args:
            body (BulkSMSRequest): Message Body
            content_type (string): TODO: type description here. Example: 
            accept (string): TODO: type description here. Example: 

        Returns:
            void: Response from the API. 

        Raises:
            APIException: When an error occurs while fetching the data from
                the remote API. This exception includes the HTTP Response
                code, an error message, and the HTTP body that was received in
                the request.

        """

        # Prepare query URL
        _url_path = '/sendbatch'
        _query_builder = Configuration.base_uri
        _query_builder += _url_path
        _query_url = APIHelper.clean_url(_query_builder)

        # Prepare headers
        _headers = {
            'Content-Type': content_type,
            'Accept': accept
        }

        # Prepare and execute request
        _request = self.http_client.post(_query_url, headers=_headers, parameters=APIHelper.json_serialize(body))
        BasicAuth.apply(_request)
        _context = self.execute_request(_request)
        self.validate_response(_context)
