package me.carlohcs.cleanarch.core.usecase;

import me.carlohcs.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer find(final String id);
}
