package me.carlohcs.cleanarch.core.dataprovider;

import me.carlohcs.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {

    Optional<Customer> find(final String id);
}
