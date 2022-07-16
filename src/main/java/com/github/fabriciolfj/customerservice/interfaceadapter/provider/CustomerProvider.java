package com.github.fabriciolfj.customerservice.interfaceadapter.provider;

import com.github.fabriciolfj.customerservice.business.PersistCustomer;
import com.github.fabriciolfj.customerservice.entities.Customer;
import com.github.fabriciolfj.customerservice.exceptions.DocumentDuplicateException;
import com.github.fabriciolfj.customerservice.exceptions.SaveException;
import com.github.fabriciolfj.customerservice.interfaceadapter.repository.CustomerRepository;
import com.github.fabriciolfj.customerservice.interfaceadapter.repository.convert.CustomerDataConvert;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerProvider implements PersistCustomer {

    private final CustomerRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(final Customer customer) {
        var result = repository.findByDocument(customer.getDocument());

        if (result.isPresent()) {
            throw new DocumentDuplicateException();
        }

        executeSave(customer);
    }

    private void executeSave(Customer customer) {
        try {
             repository.save(CustomerDataConvert.toData(customer));
        } catch (Exception e) {
            log.error("Erro save customer. Detais: {}, Parameter: {}", e.getMessage(), customer);
            throw new SaveException();
        }
    }
}
