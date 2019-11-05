/**
 * D7SMSLib
 *
 */

'use strict';

const SendSMSRequest = require('../lib/Models/SendSMSRequest');
const BulkSMSRequest = require('../lib/Models/BulkSMSRequest');
const Message = require('../lib/Models/Message');

const classMap = {
    SendSMSRequest,
    BulkSMSRequest,
    Message,
};

/**
 * Factory class to create instances of models and exception classes
 */
class ModelFactory {
    /**
     * Creates instance of a model class
     * @param  modelName  {string}  Name of class to instantiate
     * @returns  {object} Instance of the model class
     */
    static getInstance(modelName) {
        return new classMap[modelName]();
    }
}

module.exports = ModelFactory;
