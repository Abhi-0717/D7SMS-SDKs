/**
 * D7SMSLib
 *
 */

'use strict';


class BaseController {
    /**
     * Global error handling
     * @param   {HttpContext}   _context   HttpContext containing request and response objects
     * @callback    Callback function which returns error, response, context
     */
    static validateResponse(_context) {
        const errorObj = {
            errorMessage: '',
            errorCode: '',
            errorResponse: _context.response.body,
        };
        const returnObj = {
            error: errorObj,
            response: null,
            context: _context,
        };

        returnObj.error.errorMessage = 'HTTP Response Not OK';
        returnObj.error.errorCode = _context.response.statusCode;

        return returnObj;
    }
}

module.exports = BaseController;
