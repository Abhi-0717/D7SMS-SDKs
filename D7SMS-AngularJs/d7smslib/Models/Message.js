/**
 * D7SMSLib
 *
 */

;(function (angular) {
'use strict';

/**
 * Creates a instance of Message
 *
 * @constructor
 */
angular.module('D7SMSLib')
    .factory('Message', ['BaseModel', MessageModel]);

    function MessageModel(BaseModel) {
        var Message = function (obj) {
            if (obj === undefined || obj === null) {
                return;
            }
            this.to = this.getValue(obj.to);
            this.content = this.getValue(obj.content);
            this.from = this.getValue(obj.from);
        };

        Message.prototype = new BaseModel();
        Message.prototype.constructor = Message;
    
        /**
         * Function containing information about the fields of this model
         * @return   {array}   Array of objects containing information about the fields
         */
        Message.prototype.mappingInfo = function() {
            return BaseModel.prototype.mappingInfo.call(this).concat([
                { name: 'to', realName: 'to', array: true },
                { name: 'content', realName: 'content' },
                { name: 'from', realName: 'from' }
            ]);
        };
    
        /**
         * Function containing information about discriminator values
         * mapped with their corresponding model class names
         *
         * @return   {object}  Object containing Key-Value pairs mapping discriminator
         *                     values with their corresponding model classes
         */
        Message.prototype.discriminatorMap = function() {
            return {};
        };
    
        /**
         * Destination Number
         *
         * @return {array}
         */
        Message.prototype.getTo = function () {
            return this.to;
        };
    
        /**
         * Setter for To
         * 
         * @param {array} value 
         */
        Message.prototype.setTo = function (value) {
            this.to = value;
        };
    
        /**
         * TODO: Write general description for this method
         *
         * @return {string}
         */
        Message.prototype.getContent = function () {
            return this.content;
        };
    
        /**
         * Setter for Content
         * 
         * @param {string} value 
         */
        Message.prototype.setContent = function (value) {
            this.content = value;
        };
    
        /**
         * TODO: Write general description for this method
         *
         * @return {string}
         */
        Message.prototype.getFrom = function () {
            return this.from;
        };
    
        /**
         * Setter for From
         * 
         * @param {string} value 
         */
        Message.prototype.setFrom = function (value) {
            this.from = value;
        };
    
        return Message;
    }

}(angular));
