package com.github.fabriciolfj.customerservice.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Customer {

    @EqualsAndHashCode.Include
    private String code;
    private String name;
    private String document;
    private String phone;
}
