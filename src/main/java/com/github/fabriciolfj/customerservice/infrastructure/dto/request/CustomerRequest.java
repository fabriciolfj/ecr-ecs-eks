package com.github.fabriciolfj.customerservice.infrastructure.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerRequest {

    @CPF(message = "{customer.document}")
    private String document;
    @NotBlank(message = "{customer.phone}")
    private String phone;
    @NotBlank(message = "{customer.name}")
    private String name;
}
