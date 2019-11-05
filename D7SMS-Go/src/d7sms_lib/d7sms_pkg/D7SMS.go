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
 * Interface for the D7SMS_IMPL
 */
type D7SMS interface {
    API()                   api_pkg.API
    Configuration()         configuration_pkg.CONFIGURATION
}

/*
 * Factory for the D7SMS interface returning D7SMS_IMPL
 */
func NewD7SMS(aPIUsername string, aPIPassword string) D7SMS {
    d7SMSClient := new(D7SMS_IMPL)
    d7SMSClient.config = configuration_pkg.NewCONFIGURATION()

    d7SMSClient.config.SetAPIUsername(aPIUsername)
    d7SMSClient.config.SetAPIPassword(aPIPassword)

    return d7SMSClient
}
