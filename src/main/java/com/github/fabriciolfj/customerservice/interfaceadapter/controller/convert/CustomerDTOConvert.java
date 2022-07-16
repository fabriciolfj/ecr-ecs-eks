package com.github.fabriciolfj.customerservice.interfaceadapter.controller.convert;

import com.github.fabriciolfj.customerservice.entities.Customer;
import com.github.fabriciolfj.customerservice.infrastructure.dto.request.CustomerRequest;
import com.github.fabriciolfj.customerservice.infrastructure.dto.response.CustomerResponse;

import java.util.UUID;

public class CustomerDTOConvert {

    private CustomerDTOConvert() {

    }

    public static CustomerResponse toResponse(final Customer customer) {
        return CustomerResponse.builder()
                .code(customer.getCode())
                .document(customer.getDocument())
                .name(customer.getName())
                .build();
    }

    public static Customer toEntity(final CustomerRequest request) {
        return Customer.builder()
                .phone(request.getPhone())
                .document(request.getDocument())
                .code(UUID.randomUUID().toString())
                .name(request.getName())
                .build();
    }
}
