/*
 * d7sms_lib
 *
 */

package configuration_pkg



type CONFIGURATION interface {
        APIUsername() string
        SetAPIUsername(aPIUsername   string)
        APIPassword() string
        SetAPIPassword(aPIPassword   string)
}

/*
 * Factory for the CONFIGURATION interface returning CONFIGURATION_IMPL
 */
func NewCONFIGURATION() CONFIGURATION{
    configuration := new(CONFIGURATION_IMPL)
    return configuration
}