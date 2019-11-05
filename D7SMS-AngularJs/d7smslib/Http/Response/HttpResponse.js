?/**
 * D7SMSLib
 *
 */

;(function (angular) {
'use strict';

/**
 * Creates a instance of HttpResponse.
 *
 * @constructor
 */
angular.module('D7SMSLib')
    .factory('HttpResponse', [HttpResponseService]);

    function HttpResponseService() {
        return function HttpResponse() {
            this.statusCode = null;
            this.body = null;
            this.headers = null;
        };
    }

}(angular));
