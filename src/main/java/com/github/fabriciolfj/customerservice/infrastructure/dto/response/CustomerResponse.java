package com.github.fabriciolfj.customerservice.infrastructure.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerResponse {

    private String code;
    private String document;
    private String name;
}
