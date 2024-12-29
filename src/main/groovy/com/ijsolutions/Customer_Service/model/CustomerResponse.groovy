package com.ijsolutions.Customer_Service.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class CustomerResponse {
    Long customerId
    String firstName
    String lastName
    Long contactNumber
}
