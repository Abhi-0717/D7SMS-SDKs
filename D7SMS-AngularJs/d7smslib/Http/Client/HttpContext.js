?/**
 * D7SMSLib
 *
 */

;(function (angular) {
'use strict';

/**
 * Creates a instance of HttpContext.
 *
 * @constructor
 */
angular.module('D7SMSLib')
    .factory('HttpContext', [HttpContextService]);

    function HttpContextService() {
        return function HttpContext() {
            this.request = null;
            this.response = null;
        };
    }

}(angular));
