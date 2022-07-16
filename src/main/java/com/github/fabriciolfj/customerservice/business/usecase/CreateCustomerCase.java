package com.github.fabriciolfj.customerservice.business.usecase;

import com.github.fabriciolfj.customerservice.business.PersistCustomer;
import com.github.fabriciolfj.customerservice.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCustomerCase {

    private final PersistCustomer persistCustomer;

    public Customer execute(final Customer customer) {
        persistCustomer.save(customer);
        return customer;
    }
}
