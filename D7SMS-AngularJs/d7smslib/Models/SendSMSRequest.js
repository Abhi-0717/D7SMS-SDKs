/**
 * D7SMSLib
 *
 */

;(function (angular) {
'use strict';

/**
 * Creates a instance of SendSMSRequest
 *
 * @constructor
 */
angular.module('D7SMSLib')
    .factory('SendSMSRequest', ['BaseModel', SendSMSRequestModel]);

    function SendSMSRequestModel(BaseModel) {
        var SendSMSRequest = function (obj) {
            if (obj === undefined || obj === null) {
                return;
            }
            this.to = this.getValue(obj.to);
            this.from = this.getValue(obj.from);
            this.content = this.getValue(obj.content);
        };

        SendSMSRequest.prototype = new BaseModel();
        SendSMSRequest.prototype.constructor = SendSMSRequest;
    
        /**
         * Function containing information about the fields of this model
         * @return   {array}   Array of objects containing information about the fields
         */
        SendSMSRequest.prototype.mappingInfo = function() {
            return BaseModel.prototype.mappingInfo.call(this).concat([
                { name: 'to', realName: 'to' },
                { name: 'from', realName: 'from' },
                { name: 'content', realName: 'content' }
            ]);
        };
    
        /**
         * Function containing information about discriminator values
         * mapped with their corresponding model class names
         *
         * @return   {object}  Object containing Key-Value pairs mapping discriminator
         *                     values with their corresponding model classes
         */
        SendSMSRequest.prototype.discriminatorMap = function() {
            return {};
        };
    
        /**
         * Destination Mobile Number
         *
         * @return {long}
         */
        SendSMSRequest.prototype.getTo = function () {
            return this.to;
        };
    
        /**
         * Setter for To
         * 
         * @param {long} value 
         */
        SendSMSRequest.prototype.setTo = function (value) {
            this.to = value;
        };
    
        /**
         * Sender ID / Number
         *
         * @return {string}
         */
        SendSMSRequest.prototype.getFrom = function () {
            return this.from;
        };
    
        /**
         * Setter for From
         * 
         * @param {string} value 
         */
        SendSMSRequest.prototype.setFrom = function (value) {
            this.from = value;
        };
    
        /**
         * Message Content
         *
         * @return {string}
         */
        SendSMSRequest.prototype.getContent = function () {
            return this.content;
        };
    
        /**
         * Setter for Content
         * 
         * @param {string} value 
         */
        SendSMSRequest.prototype.setContent = function (value) {
            this.content = value;
        };
    
        return SendSMSRequest;
    }

}(angular));
