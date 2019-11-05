/**
 * D7SMSLib
 *
 */

;(function (angular) {
'use strict';

angular.module('D7SMSLib')
    .factory('APIController', ['$q', 'Configuration', 'HttpClient', 'APIHelper', 'BaseController', APIController
    ]);

    function APIController($q, Configuration, HttpClient, APIHelper, BaseController) {
        return {
            /**
             * Check account balance
             *
             *
             * @return {promise<Void>}
             */
            getBalance: function () {

                //Create promise to return
                var _deffered = $q.defer();
                
                //prepare query string for API call
                var _baseUri = Configuration.BASEURI;
                var _queryBuilder = _baseUri + '/balance';
                
                //validate and preprocess url
                var _queryUrl = APIHelper.cleanUrl(_queryBuilder);
                
                // prepare and invoke the API call request to fetch the response
                var _config = {
                    method: 'GET',
                    queryUrl: _queryUrl,
                    username: Configuration.aPIUsername,
                    password: Configuration.aPIPassword,
                };
                
                var _response = new HttpClient(_config);
                
                //process response
                _response.then(function success(_result) {
                    _deffered.resolve(_result);
                }, function error(_result){
                    // Error handling for custom HTTP status codes
                    if (_result.code === 500) {
                        _deffered.reject(APIHelper.appendContext({
                            errorMessage:'Internal Server Error',
                            errorCode: 500,
                            errorResponse: _result.message
                        }, _result.getContext()));
                    } else {
                        _deffered.reject(APIHelper.appendContext({
                            errorMessage:'HTTP Response Not OK',
                            errorCode: _result.code,
                            errorResponse: _result.message
                        }, _result.getContext()));
                    }
                });
                
                return _deffered.promise;
            },
            /**
             * Send SMS  to recipients using D7 SMS Gateway
             *
             * @param {array}  input    Array with all options for search
             * @param {SendSMSRequest} input['body'] Message Body
             * @param {string} input['contentType'] TODO: type description here
             * @param {string} input['accept'] TODO: type description here
             *
             * @return {promise<Void>}
             */
            createSendSMS: function (input) {
                // Assign default values
                input = input || {};

                //Create promise to return
                var _deffered = $q.defer();
                
                //prepare query string for API call
                var _baseUri = Configuration.BASEURI;
                var _queryBuilder = _baseUri + '/send';
                
                //validate and preprocess url
                var _queryUrl = APIHelper.cleanUrl(_queryBuilder);
                
                // prepare headers
                var _headers = {
                    'content-type': 'application/json; charset=utf-8',
                    'Content-Type': input.contentType,
                    'Accept': input.accept
                };

                // Remove null values
                APIHelper.cleanObject(input.body);

                // prepare and invoke the API call request to fetch the response
                var _config = {
                    method: 'POST',
                    queryUrl: _queryUrl,
                    headers: _headers,
                    username: Configuration.aPIUsername,
                    password: Configuration.aPIPassword,
                    body: input.body
                };
                
                var _response = new HttpClient(_config);
                
                //process response
                _response.then(function success(_result) {
                    _deffered.resolve(_result);
                }, function error(_result){
                    // Error handling for custom HTTP status codes
                    if (_result.code === 500) {
                        _deffered.reject(APIHelper.appendContext({
                            errorMessage:'Internal Server Error',
                            errorCode: 500,
                            errorResponse: _result.message
                        }, _result.getContext()));
                    } else {
                        _deffered.reject(APIHelper.appendContext({
                            errorMessage:'HTTP Response Not OK',
                            errorCode: _result.code,
                            errorResponse: _result.message
                        }, _result.getContext()));
                    }
                });
                
                return _deffered.promise;
            },
            /**
             * Send Bulk SMS  to multiple recipients using D7 SMS Gateway
             *
             * @param {BulkSMSRequest} body Message Body
             * @param {string} contentType TODO: type description here
             * @param {string} accept TODO: type description here
             *
             * @return {promise<Void>}
             */
            createBulkSMS: function (body, contentType, accept) {

                //Create promise to return
                var _deffered = $q.defer();
                
                //prepare query string for API call
                var _baseUri = Configuration.BASEURI;
                var _queryBuilder = _baseUri + '/sendbatch';
                
                //validate and preprocess url
                var _queryUrl = APIHelper.cleanUrl(_queryBuilder);
                
                // prepare headers
                var _headers = {
                    'content-type': 'application/json; charset=utf-8',
                    'Content-Type': contentType,
                    'Accept': accept
                };

                // Remove null values
                APIHelper.cleanObject(body);

                // prepare and invoke the API call request to fetch the response
                var _config = {
                    method: 'POST',
                    queryUrl: _queryUrl,
                    headers: _headers,
                    username: Configuration.aPIUsername,
                    password: Configuration.aPIPassword,
                    body: body.toJSON()
                };
                
                var _response = new HttpClient(_config);
                
                //process response
                _response.then(function success(_result) {
                    _deffered.resolve(_result);
                }, function error(_result){
                    // Error handling for custom HTTP status codes
                    _deffered.reject(APIHelper.appendContext({
                        errorMessage:'HTTP Response Not OK',
                        errorCode: _result.code,
                        errorResponse: _result.message
                    }, _result.getContext()));
                });
                
                return _deffered.promise;
            }
        };
    }

}(angular));
