package me.carlohcs.cleanarch.core.usecase;

import me.carlohcs.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {
    void insert(Customer customer, String zipCode);
}
