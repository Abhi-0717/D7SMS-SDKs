?/**
 * D7SMSLib
 *
 */

;(function (angular) {
'use strict';

/**
 * Creates a instance of HttpRequest.
 *
 * @constructor
 */
angular.module('D7SMSLib')
    .factory('HttpRequest', [HttpRequestService]);

    function HttpRequestService() {
        return function HttpRequest() {
            this.queryUrl = null;
            this.method = null;
            this.headers = null;
            this.username = null;
            this.password = null;
            this.body = null;
            this.formData = null;
            this.form = null;
        };
    }

}(angular));
