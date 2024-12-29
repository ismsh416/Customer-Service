package com.ijsolutions.Customer_Service.exception

import groovy.transform.InheritConstructors
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@InheritConstructors
@ResponseStatus(code = HttpStatus.NOT_FOUND)
class NotFoundException extends Exception{
    NotFoundException(String msg){
        super(msg)
    }
}