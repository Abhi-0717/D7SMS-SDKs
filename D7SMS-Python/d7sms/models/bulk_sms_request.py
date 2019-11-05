# -*- coding: utf-8 -*-

"""
    d7sms

"""

import d7sms.models.message

class BulkSMSRequest(object):

    """Implementation of the 'Bulk SMS Request' model.

    Bulk SMS Request

    Attributes:
        messages (list of Message): Sendbatch message body

    """

    # Create a mapping from Model property names to API property names
    _names = {
        "messages":'messages'
    }

    def __init__(self,
                 messages=None):
        """Constructor for the BulkSMSRequest class"""

        # Initialize members of the class
        self.messages = messages


    @classmethod
    def from_dictionary(cls,
                        dictionary):
        """Creates an instance of this model from a dictionary

        Args:
            dictionary (dictionary): A dictionary representation of the object as
            obtained from the deserialization of the server's response. The keys
            MUST match property names in the API description.

        Returns:
            object: An instance of this structure class.

        """
        if dictionary is None:
            return None

        # Extract variables from the dictionary
        messages = None
        if dictionary.get('messages') != None:
            messages = list()
            for structure in dictionary.get('messages'):
                messages.append(d7sms.models.message.Message.from_dictionary(structure))

        # Return an object of this model
        return cls(messages)


