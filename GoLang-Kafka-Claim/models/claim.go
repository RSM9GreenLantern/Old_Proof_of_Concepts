package claim

type Claim struct {
    ClaimID struct {
        Oid string `json:"$oid"`
    } `json:"ClaimID"`
    MemberfirstName string      `json:"Memberfirst_name"`
    MemberlastName  string      `json:"Memberlast_name"`
    Source          string      `json:"Source"`
    Event           string      `json:"Event"`
    Breed           string      `json:"Breed"`
    TimeStamp       interface{} `json:"TimeStamp"`
}
