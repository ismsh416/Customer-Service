package com.ijsolutions.Customer_Service.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import jakarta.validation.constraints.NotEmpty

@EqualsAndHashCode
@ToString
class CustomerRequest {
    String firstName
    String lastName

    @NotEmpty
    Long contactNumber
}
