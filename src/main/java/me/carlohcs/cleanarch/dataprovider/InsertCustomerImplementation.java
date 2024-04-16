package me.carlohcs.cleanarch.dataprovider;

import me.carlohcs.cleanarch.core.dataprovider.InsertCustomer;
import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.dataprovider.repository.CustomerRepository;
import me.carlohcs.cleanarch.dataprovider.repository.entity.CustomerEntity;
import me.carlohcs.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImplementation implements InsertCustomer {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);

        customerRepository.save(customerEntity);
    }
}
