package com.github.fabriciolfj.customerservice.interfaceadapter.provider;

import com.github.fabriciolfj.customerservice.business.FindCustomer;
import com.github.fabriciolfj.customerservice.entities.Customer;
import com.github.fabriciolfj.customerservice.exceptions.CustomerNotFoundException;
import com.github.fabriciolfj.customerservice.interfaceadapter.controller.convert.CustomerDTOConvert;
import com.github.fabriciolfj.customerservice.interfaceadapter.repository.CustomerRepository;
import com.github.fabriciolfj.customerservice.interfaceadapter.repository.convert.CustomerDataConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class QueryCustomerProvider implements FindCustomer {

    private final CustomerRepository repository;

    @Override
    public Customer get(final String code) {
        return repository.findByCode(code)
                .map(CustomerDataConvert::toEntity)
                .orElseThrow(() -> new CustomerNotFoundException());
    }
}
