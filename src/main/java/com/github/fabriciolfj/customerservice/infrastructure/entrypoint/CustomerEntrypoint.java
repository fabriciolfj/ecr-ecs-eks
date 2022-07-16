package com.github.fabriciolfj.customerservice.infrastructure.entrypoint;

import com.github.fabriciolfj.customerservice.infrastructure.dto.request.CustomerRequest;
import com.github.fabriciolfj.customerservice.infrastructure.dto.response.CustomerResponse;
import com.github.fabriciolfj.customerservice.interfaceadapter.controller.CustomerController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerEntrypoint {

    private final CustomerController controller;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@Validated @RequestBody final CustomerRequest request) {
        return controller.create(request);
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CustomerResponse find(@PathVariable("code") final String code) {
        return controller.findByCode(code);
    }
}
