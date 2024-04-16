package me.carlohcs.cleanarch.dataprovider;

import me.carlohcs.cleanarch.core.dataprovider.UpdateCustomer;
import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.dataprovider.repository.CustomerRepository;
import me.carlohcs.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImplementation implements UpdateCustomer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);

        customerRepository.save(customerEntity);
    }
}
