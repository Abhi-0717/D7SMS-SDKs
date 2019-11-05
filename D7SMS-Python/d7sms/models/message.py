# -*- coding: utf-8 -*-

"""
    d7sms

"""


class Message(object):

    """Implementation of the 'Message' model.

    TODO: type model description here.

    Attributes:
        to (list of string): Destination Number
        content (string): TODO: type description here.
        mfrom (string): TODO: type description here.

    """

    # Create a mapping from Model property names to API property names
    _names = {
        "to":'to',
        "content":'content',
        "mfrom":'from'
    }

    def __init__(self,
                 to=None,
                 content=None,
                 mfrom=None):
        """Constructor for the Message class"""

        # Initialize members of the class
        self.to = to
        self.content = content
        self.mfrom = mfrom


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
        content = dictionary.get('content')
        mfrom = dictionary.get('from')

        # Return an object of this model
        return cls(to,
                   content,
                   mfrom)


