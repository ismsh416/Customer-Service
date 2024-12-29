package com.ijsolutions.Customer_Service.service

import com.ijsolutions.Customer_Service.domain.Customer
import com.ijsolutions.Customer_Service.model.CustomerRequest
import com.ijsolutions.Customer_Service.model.CustomerResponse
import com.ijsolutions.Customer_Service.repository.CustomerRepository
import com.ijsolutions.Customer_Service.exception.NotFoundException
import groovy.util.logging.Slf4j
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Slf4j
class CustomerService {
    @Autowired
    CustomerRepository customerRepository

    CustomerResponse createCustomer(CustomerRequest customerRequest) {
        log.info 'customer={}', customerRequest
        Customer customer = customerRepository.save(convertToDomain(customerRequest))
        convertToModel(customer)

    }

    CustomerResponse getByCustomerId(Long customerId) {
        convertToModel(findById(customerId))
    }

    List<CustomerResponse> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll()
        List<CustomerResponse> customerResponseList = []
        customerList.each {
            customerResponseList.add(convertToModel(it))
        }
        customerResponseList
    }

    void deleteById(Long customerId){
        customerRepository.delete(findById(customerId))
    }

    private Customer findById(Long customerId) {
        customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException('customerId ' + customerId + 'not found'))
    }

    private Customer convertToDomain(CustomerRequest customerRequest){
        Customer customer =  new Customer()
        BeanUtils.copyProperties(customerRequest, customer)
        return customer

    }

    private CustomerResponse convertToModel(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse()
        BeanUtils.copyProperties(customer, customerResponse)
        return customerResponse
    }
}
