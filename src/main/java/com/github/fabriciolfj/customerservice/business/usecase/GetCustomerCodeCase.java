package com.github.fabriciolfj.customerservice.business.usecase;

import com.github.fabriciolfj.customerservice.business.FindCustomer;
import com.github.fabriciolfj.customerservice.entities.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetCustomerCodeCase {

    private final FindCustomer findCustomer;

    public Customer execute(final String code) {
        log.info("Find customer by code : {}", code);
        return findCustomer.get(code);
    }
}
