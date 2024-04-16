package me.carlohcs.cleanarch.core.usecase;

import me.carlohcs.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {

    void update(Customer customer, String zipCode);
}
