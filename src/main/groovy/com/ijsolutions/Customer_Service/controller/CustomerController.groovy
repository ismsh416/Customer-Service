package com.ijsolutions.Customer_Service.controller

import com.ijsolutions.Customer_Service.model.CustomerRequest
import com.ijsolutions.Customer_Service.model.CustomerResponse
import com.ijsolutions.Customer_Service.service.CustomerService
import groovy.util.logging.Slf4j
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/customer')
@Slf4j
class CustomerController {

    @Autowired
    CustomerService customerService

    @Autowired
    Environment environment
    @PostMapping
    ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request) {
        def response = customerService.createCustomer(request)
        new ResponseEntity<>(response, HttpStatus.CREATED)
    }

    @GetMapping(value = '/{customerId}')
    ResponseEntity<CustomerResponse> getByCustomerId(@PathVariable(name = 'customerId') Long customerId) {
        MDC.put('customerId', customerId.toString())
        log.info('getByCustomerId={}, env={}', customerId, environment.getProperty('local.server.port'))
        def response = customerService.getByCustomerId(customerId)
        new ResponseEntity<>(response, HttpStatus.OK)
    }

    @GetMapping
    ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        def response = customerService.getAllCustomer()
        new ResponseEntity<>(response, HttpStatus.OK)
    }

    @DeleteMapping('/{customerId}')
    ResponseEntity<CustomerResponse> deleteIById(@PathVariable(name = 'customerId') Long customerId) {
        def response = customerService.deleteById(customerId)
        new ResponseEntity<>(response, HttpStatus.NO_CONTENT)
    }
}
