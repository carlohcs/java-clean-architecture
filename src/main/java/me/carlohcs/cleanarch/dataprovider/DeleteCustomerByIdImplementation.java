package me.carlohcs.cleanarch.dataprovider;

import me.carlohcs.cleanarch.core.dataprovider.DeleteCustomerById;
import me.carlohcs.cleanarch.dataprovider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdImplementation implements DeleteCustomerById {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
