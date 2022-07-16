package com.github.fabriciolfj.customerservice.interfaceadapter.repository.convert;

import com.github.fabriciolfj.customerservice.entities.Customer;
import com.github.fabriciolfj.customerservice.interfaceadapter.repository.data.CustomerData;

public class CustomerDataConvert {

    private CustomerDataConvert() {

    }

    public static CustomerData toData(final Customer customer) {
        return CustomerData.builder()
                .code(customer.getCode())
                .document(customer.getDocument())
                .phone(customer.getPhone())
                .name(customer.getName())
                .build();
    }

    public static Customer toEntity(final CustomerData data) {
        return Customer.builder()
                .code(data.getCode())
                .document(data.getDocument())
                .phone(data.getPhone())
                .build();
    }
}
