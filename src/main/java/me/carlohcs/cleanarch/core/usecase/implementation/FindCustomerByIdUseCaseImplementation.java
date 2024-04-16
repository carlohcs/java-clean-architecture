package me.carlohcs.cleanarch.core.usecase.implementation;

import me.carlohcs.cleanarch.core.dataprovider.FindCustomerById;
import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImplementation implements FindCustomerByIdUseCase {

    private final FindCustomerById findCustomerById;

    public FindCustomerByIdUseCaseImplementation(FindCustomerById findCustomerById) {
        this.findCustomerById = findCustomerById;
    }

    @Override
    public Customer find(String id) {
        return findCustomerById.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
