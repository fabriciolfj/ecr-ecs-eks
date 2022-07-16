package com.github.fabriciolfj.customerservice.business;

import com.github.fabriciolfj.customerservice.entities.Customer;

public interface PersistCustomer {

    void save(final Customer customer);
}
