/**
 * D7SMSLib
 *
 */

'use strict';

const configuration = require("../lib/configuration");
const environments = require("../lib/Environments");

const testConfiguration = {
    ASSERT_PRECISION: 0.01,
    TEST_TIMEOUT: 30000
};

configuration.currentEnvironment = environments.PRODUCTION;


module.exports = testConfiguration;
