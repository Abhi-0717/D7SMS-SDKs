/**
  * @module D7SMSLib
  *
  * D7 SMS allows you to reach your customers via SMS over D7's own connectivity to global mobile
  * networks. D7 provides reliable and cost-effective SMS services to businesses across all
  * industries and aims to connect all countries and territories via direct connections.
  */

'use strict';

const Configuration = require('./configuration');
const APIController = require('./Controllers/APIController');
const SendSMSRequest = require('./Models/SendSMSRequest');
const BulkSMSRequest = require('./Models/BulkSMSRequest');
const Message = require('./Models/Message');
const APIException = require('./Exceptions/APIException');


const initializer = {
    // functional components of D7SMSLib
    Configuration,
    // controllers of D7SMSLib
    APIController,
    // models of D7SMSLib
    SendSMSRequest,
    BulkSMSRequest,
    Message,
    // exceptions of D7SMSLib
    APIException,
};

module.exports = initializer;
