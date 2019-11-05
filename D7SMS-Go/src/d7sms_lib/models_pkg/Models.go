/*
 * d7sms_lib
 *
 */

package models_pkg



/*
 * Structure for the custom type SendSMSRequest
 */
type SendSMSRequest struct {
    To              int64           `json:"to" form:"to"` //Destination Mobile Number
    From            string          `json:"from" form:"from"` //Sender ID / Number
    Content         string          `json:"content" form:"content"` //Message Content
}

/*
 * Structure for the custom type BulkSMSRequest
 */
type BulkSMSRequest struct {
    Messages        []*Message      `json:"messages" form:"messages"` //Sendbatch message body
}

/*
 * Structure for the custom type Message
 */
type Message struct {
    To              []string        `json:"to" form:"to"` //Destination Number
    Content         string          `json:"content" form:"content"` //TODO: Write general description for this field
    From            string          `json:"from" form:"from"` //TODO: Write general description for this field
}
