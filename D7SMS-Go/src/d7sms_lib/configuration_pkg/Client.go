/*
 * d7sms_lib
 *
 */

package configuration_pkg


/** The base Uri for API calls */
const BASEURI string = "https://rest-api.d7networks.com/secure"



type CONFIGURATION_IMPL struct {
    /** API Key */
    /** Replace the value of APIUsername with an appropriate value */
    api_username string
    /** API Token */
    /** Replace the value of APIPassword with an appropriate value */
    api_password string
}

/*
 * Getter function returning api_username
 */
func (me *CONFIGURATION_IMPL) APIUsername() string{
    return me.api_username
}

/*
 * Setter function setting up api_username
 */
func (me *CONFIGURATION_IMPL) SetAPIUsername(aPIUsername string) {
    me.api_username = aPIUsername
}

/*
 * Getter function returning api_password
 */
func (me *CONFIGURATION_IMPL) APIPassword() string{
    return me.api_password
}

/*
 * Setter function setting up api_password
 */
func (me *CONFIGURATION_IMPL) SetAPIPassword(aPIPassword string) {
    me.api_password = aPIPassword
}

