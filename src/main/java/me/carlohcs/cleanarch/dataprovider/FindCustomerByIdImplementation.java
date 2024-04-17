package me.carlohcs.cleanarch.dataprovider;

import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.core.dataprovider.FindCustomerById;
import me.carlohcs.cleanarch.dataprovider.repository.CustomerRepository;
import me.carlohcs.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImplementation implements FindCustomerById {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

}
