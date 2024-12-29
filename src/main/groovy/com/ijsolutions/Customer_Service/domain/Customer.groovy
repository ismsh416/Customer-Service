package com.ijsolutions.Customer_Service.domain

import groovy.transform.ToString
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
@ToString
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    Long customerId
    String firstName
    String lastName
    Long contactNumber
}
