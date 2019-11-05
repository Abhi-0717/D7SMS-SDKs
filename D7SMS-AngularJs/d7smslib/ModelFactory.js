/**
 * D7SMSLib
 *
 */

;(function (angular) {
'use strict';
angular.module('D7SMSLib')
    .factory('ModelFactory', ['SendSMSRequest', 'BulkSMSRequest', 'Message',ModelFactory]);

	/**
	 * Factory service to create instances of models and exception classes
	 */
    function ModelFactory(SendSMSRequest, BulkSMSRequest, Message) {

		var classMap = {
            SendSMSRequest: SendSMSRequest,
            BulkSMSRequest: BulkSMSRequest,
            Message: Message
		};

		return {
		    /**
		     * Creates instance of a model class
		     * @param  modelName  {string}  Name of class to instantiate
		     * @returns  {object} Instance of the model class
		     */
			getInstance: function(modelName) {
        		return new classMap[modelName]();
			}
		};
	}

}(angular));
