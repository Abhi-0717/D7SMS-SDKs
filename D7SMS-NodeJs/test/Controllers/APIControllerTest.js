/**
 * D7SMSLib
 *
 */

'use strict';

const chai = require('chai');
const assert = chai.assert;
const TestHelper = require("../TestHelper");
const APIHelper = require("../../lib/APIHelper");
const testerlib = require("../../lib");
const testConfiguration = require("../TestBootstrap");
const baseController = require("../../lib/Controllers/BaseController");

const controller = testerlib.APIController;
const SendSMSRequest = testerlib.SendSMSRequest;
const BulkSMSRequest = testerlib.BulkSMSRequest;
const Message = testerlib.Message;


describe("APIController Tests", function tests() {
    this.timeout(testConfiguration.TEST_TIMEOUT);

    /**
     * Check Balance
     */
    it("should testBalance response", function testBalanceTest(done) {
        controller.getBalance(function callback(error, response, context) {
            // test response code
            assert.equal(500, context.response.statusCode);
            done();
        }).catch(() => undefined);
    });

    /**
     * Send SMS  to a recipient using D7 SMS Gateway
     */
    it("should testSendSMS response", function testSendSMSTest(done) {
        // parameters for the API call
        let input = [];
        input['body'] = baseController.getObjectMapper().mapObject({  "to": 971562316353,  "from": "SignSMS",  "content": "Send single SMS Testing"}, 'SendSMSRequest');
        input['contentType'] = 'application/json';
        input['accept'] = 'application/json';

        controller.createSendSMS(input, function callback(error, response, context) {
            // test response code
            assert.equal(500, context.response.statusCode);
            done();
        }).catch(() => undefined);
    });

    /**
     * Send SMS  to multiple recipients using D7 SMS Gateway
     */
    it("should testBulkSMS response", function testBulkSMSTest(done) {
        // parameters for the API call
        let body = baseController.getObjectMapper().mapObject({  "messages": [    {      "to": [        "971562316353",        "971562316354",        "971562316355"      ],      "content": "Same content goes to three numbers",      "from": "SignSMS"    }  ]}, 'BulkSMSRequest');
        let contentType = 'application/json';
        let accept = 'application/json';

        controller.createBulkSMS(body, contentType, accept, function callback(error, response, context) {
            // test response code
            assert.equal(500, context.response.statusCode);
            done();
        }).catch(() => undefined);
    });
});
