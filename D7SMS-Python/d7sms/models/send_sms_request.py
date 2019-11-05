# -*- coding: utf-8 -*-

"""
    d7sms

"""


class SendSMSRequest(object):

    """Implementation of the 'Send SMS Request' model.

    Send SMS Request

    Attributes:
        to (long|int): Destination Mobile Number
        mfrom (string): Sender ID / Number
        content (string): Message Content

    """

    # Create a mapping from Model property names to API property names
    _names = {
        "to":'to',
        "mfrom":'from',
        "content":'content'
    }

    def __init__(self,
                 to=None,
                 mfrom=None,
                 content=None):
        """Constructor for the SendSMSRequest class"""

        # Initialize members of the class
        self.to = to
        self.mfrom = mfrom
        self.content = content


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
        to = dictionary.get('to')
        mfrom = dictionary.get('from')
        content = dictionary.get('content')

        # Return an object of this model
        return cls(to,
                   mfrom,
                   content)


