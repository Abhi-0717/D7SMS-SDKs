# -*- coding: utf-8 -*-

"""
    d7sms

"""

import jsonpickle
import dateutil.parser
from .controller_test_base import ControllerTestBase
from ..test_helper import TestHelper
from d7sms.api_helper import APIHelper
from d7sms.models.send_sms_request import SendSMSRequest
from d7sms.models.bulk_sms_request import BulkSMSRequest
from d7sms.exceptions.api_exception import APIException


class APIControllerTests(ControllerTestBase):

    @classmethod
    def setUpClass(cls):
        super(APIControllerTests, cls).setUpClass()
        cls.controller = cls.api_client.client

    # Check Balance
    def test_balance(self):

        # Perform the API call through the SDK function
        with self.assertRaises(APIException):
            self.controller.get_balance()

        # Test response code
        self.assertEquals(self.response_catcher.response.status_code, 500)

    # Send SMS  to a recipient using D7 SMS Gateway
    def test_send_sms(self):
        # Parameters for the API call
        options = {}
        options['body'] = APIHelper.json_deserialize('{"to":971562316353,"from":"SignSMS","content":"Send single SMS Testing"}', SendSMSRequest.from_dictionary)
        options['content_type'] = 'application/json'
        options['accept'] = 'application/json'

        # Perform the API call through the SDK function
        with self.assertRaises(APIException):
            self.controller.create_send_sms(options)

        # Test response code
        self.assertEquals(self.response_catcher.response.status_code, 500)

    # Send SMS  to multiple recipients using D7 SMS Gateway
    def test_bulk_sms(self):
        # Parameters for the API call
        body = APIHelper.json_deserialize(
            '{"messages":[{"to":["971562316353","971562316354","971562316355"],"content'
            '":"Same content goes to three numbers","from":"SignSMS"}]}'
            , BulkSMSRequest.from_dictionary)
        content_type = 'application/json'
        accept = 'application/json'

        # Perform the API call through the SDK function
        with self.assertRaises(APIException):
            self.controller.create_bulk_sms(body, content_type, accept)

        # Test response code
        self.assertEquals(self.response_catcher.response.status_code, 500)

