# -*- coding: utf-8 -*-

"""
    d7sms

"""

from d7sms.api_helper import APIHelper


class Configuration(object):

    """A class used for configuring the SDK by a user.

    This class need not be instantiated and all properties and methods
    are accessible without instance creation.

    """

    # Set the array parameter serialization method
    # (allowed: indexed, unindexed, plain, csv, tsv, psv)
    array_serialization = "indexed"

    # The base Uri for API calls
    base_uri = 'https://rest-api.d7networks.com/secure'

    # API Key
    # TODO: Set an appropriate value
    api_username = None

    # API Token
    # TODO: Set an appropriate value
    api_password = None

