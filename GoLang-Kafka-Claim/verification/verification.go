package verification

import (
    "reflect"
    "fmt"

    . "github.com/SunPriest/GoLang-Kafka-Claim/models"
)

//Verification step currently prints field name, type and value to console, Proof of concept that these values can be operated on by logic
func verify(c Claim) {
    claimReflect := reflect.ValueOf(&c).Elem()
    typeOfClaim := claimReflect.Type()

    for i := 0; i < claimReflect.NumField(); i++ {
        field := claimReflect.Field(i)
        fmt.Printf("%d: %s %s = %v\n", i,
            typeOfClaim.Field(i).Name, field.Type(), field.Interface())
    }
}
