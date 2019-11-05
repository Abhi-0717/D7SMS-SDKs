/**
 * D7SMSLib
 *
 */

'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of Message
 */
class Message extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.to = this.constructor.getValue(obj.to);
        this.content = this.constructor.getValue(obj.content);
        this.from = this.constructor.getValue(obj.from);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'to', realName: 'to', array: true },
            { name: 'content', realName: 'content' },
            { name: 'from', realName: 'from' },
        ]);
    }

    /**
     * Function containing information about discriminator values
     * mapped with their corresponding model class names
     *
     * @return   {object}  Object containing Key-Value pairs mapping discriminator
     *                     values with their corresponding model classes
     */
    static discriminatorMap() {
        return {};
    }
}

module.exports = Message;
