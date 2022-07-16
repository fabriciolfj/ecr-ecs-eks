package com.github.fabriciolfj.customerservice.interfaceadapter.controller;

import com.github.fabriciolfj.customerservice.business.usecase.CreateCustomerCase;
import com.github.fabriciolfj.customerservice.business.usecase.GetCustomerCodeCase;
import com.github.fabriciolfj.customerservice.infrastructure.dto.request.CustomerRequest;
import com.github.fabriciolfj.customerservice.infrastructure.dto.response.CustomerResponse;
import com.github.fabriciolfj.customerservice.interfaceadapter.controller.convert.CustomerDTOConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerCase createCustomerCase;
    private final GetCustomerCodeCase getCustomerCodeCase;

    public CustomerResponse create(final CustomerRequest request) {
        var customer = createCustomerCase.execute(CustomerDTOConvert.toEntity(request));
        return CustomerDTOConvert.toResponse(customer);
    }

    public CustomerResponse findByCode(final String code) {
        var customer = getCustomerCodeCase.execute(code);
        return CustomerDTOConvert.toResponse(customer);
    }
}
