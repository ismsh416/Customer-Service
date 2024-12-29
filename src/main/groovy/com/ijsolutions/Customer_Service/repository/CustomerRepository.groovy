package com.ijsolutions.Customer_Service.repository

import com.ijsolutions.Customer_Service.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository extends JpaRepository<Customer, Long>{

}