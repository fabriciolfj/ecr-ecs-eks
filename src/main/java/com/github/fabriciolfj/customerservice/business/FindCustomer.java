package com.github.fabriciolfj.customerservice.business;

import com.github.fabriciolfj.customerservice.entities.Customer;

public interface FindCustomer {

    Customer get(final String code);
}
