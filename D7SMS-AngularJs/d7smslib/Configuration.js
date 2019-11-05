/**
 * D7SMSLib
 *
 */

;(function (angular) {
'use strict';

angular.module('D7SMSLib')
    .factory('Configuration', [Configuration]);

    function Configuration() {
        return {
            //The base Uri for API calls
            BASEURI : 'https://rest-api.d7networks.com/secure',

            //API Key
            aPIUsername : '',

            //API Token
            aPIPassword : ''

        };
    }

}(angular));
