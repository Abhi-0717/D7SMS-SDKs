/*
 * d7sms_lib
 *
 */

package apiclient_pkg

import "d7sms_lib/configuration_pkg"
import "d7sms_lib/models_pkg"

/*
 * Interface for the APICLIENT_IMPL
 */
type APICLIENT interface {
    GetBalance () (error)

    CreateSendSMS (*CreateSendSMSInput) (error)

    CreateBulkSMS (*models_pkg.BulkSMSRequest, string, string) (error)
}

/*
 * Factory for the APICLIENT interaface returning APICLIENT_IMPL
 */
func NewAPICLIENT(config configuration_pkg.CONFIGURATION) *APICLIENT_IMPL {
    client := new(APICLIENT_IMPL)
    client.config = config
    return client
}