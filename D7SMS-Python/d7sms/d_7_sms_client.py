# -*- coding: utf-8 -*-

"""
    d7sms

"""

from d7sms.decorators import lazy_property
from d7sms.configuration import Configuration
from d7sms.controllers.api_controller import APIController


class D7smsClient(object):

    config = Configuration

    @lazy_property
    def client(self):
        return APIController()


    def __init__(self,
                 api_username=None,
                 api_password=None):
        if api_username is not None:
            Configuration.api_username = api_username
        if api_password is not None:
            Configuration.api_password = api_password

