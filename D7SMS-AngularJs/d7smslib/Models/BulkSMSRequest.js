/**
 * D7SMSLib
 *
 */

;(function (angular) {
'use strict';

/**
 * Creates a instance of BulkSMSRequest
 *
 * @constructor
 */
angular.module('D7SMSLib')
    .factory('BulkSMSRequest', ['BaseModel', BulkSMSRequestModel]);

    function BulkSMSRequestModel(BaseModel) {
        var BulkSMSRequest = function (obj) {
            if (obj === undefined || obj === null) {
                return;
            }
            this.messages = this.getValue(obj.messages);
        };

        BulkSMSRequest.prototype = new BaseModel();
        BulkSMSRequest.prototype.constructor = BulkSMSRequest;
    
        /**
         * Function containing information about the fields of this model
         * @return   {array}   Array of objects containing information about the fields
         */
        BulkSMSRequest.prototype.mappingInfo = function() {
            return BaseModel.prototype.mappingInfo.call(this).concat([
                { name: 'messages', realName: 'messages', array: true, type: 'Message' }
            ]);
        };
    
        /**
         * Function containing information about discriminator values
         * mapped with their corresponding model class names
         *
         * @return   {object}  Object containing Key-Value pairs mapping discriminator
         *                     values with their corresponding model classes
         */
        BulkSMSRequest.prototype.discriminatorMap = function() {
            return {};
        };
    
        /**
         * Sendbatch message body
         *
         * @return {array}
         */
        BulkSMSRequest.prototype.getMessages = function () {
            return this.messages;
        };
    
        /**
         * Setter for Messages
         * 
         * @param {array} value 
         */
        BulkSMSRequest.prototype.setMessages = function (value) {
            this.messages = value;
        };
    
        return BulkSMSRequest;
    }

}(angular));
