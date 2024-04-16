package me.carlohcs.cleanarch.core.usecase.implementation;

import me.carlohcs.cleanarch.core.dataprovider.FindAddressByZipCode;
import me.carlohcs.cleanarch.core.dataprovider.UpdateCustomer;
import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.core.usecase.FindCustomerByIdUseCase;
import me.carlohcs.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImplementation implements UpdateCustomerUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final FindAddressByZipCode findAddressByZipCode;

    private final UpdateCustomer updateCustomer;

    public UpdateCustomerUseCaseImplementation(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCode findAddressByZipCode,
            UpdateCustomer updateCustomer
    ) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomer = updateCustomer;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdUseCase.find(customer.getId());

        var address = findAddressByZipCode.find(zipCode);

        customer.setAddress(address);

        updateCustomer.update(customer);
    }
}
