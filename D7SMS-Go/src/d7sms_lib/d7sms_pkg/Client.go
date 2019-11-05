/*
 * d7sms_lib
 *
 */

package D7SMSClient

import(
	"d7sms_lib/configuration_pkg"
	"d7sms_lib/api_pkg"
)
/*
 * Client structure as interface implementation
 */
type D7SMS_IMPL struct {
     api api_pkg.API
     config  configuration_pkg.CONFIGURATION
}

/**
     * Access to Configuration
     * @return Returns the Configuration instance
*/
func (me *D7SMS_IMPL) Configuration() configuration_pkg.CONFIGURATION {
    return me.config
}
/**
     * Access to API controller
     * @return Returns the API() instance
*/
func (me *D7SMS_IMPL) API() api_pkg.API {
    if(me.api) == nil {
        me.api = api_pkg.NewAPI(me.config)
    }
    return me.api
}

