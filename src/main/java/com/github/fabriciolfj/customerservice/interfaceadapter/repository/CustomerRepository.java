package com.github.fabriciolfj.customerservice.interfaceadapter.repository;

import com.github.fabriciolfj.customerservice.interfaceadapter.repository.data.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerData, Long> {

    Optional<CustomerData> findByCode(final String code);

    Optional<CustomerData> findByDocument(final String document);
}
