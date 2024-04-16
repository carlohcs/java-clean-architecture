package me.carlohcs.cleanarch.core.usecase.implementation;

import me.carlohcs.cleanarch.core.dataprovider.DeleteCustomerById;
import me.carlohcs.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import me.carlohcs.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseImplementation implements DeleteCustomerByIdUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final DeleteCustomerById deleteCustomerById;

    public DeleteCustomerByIdUseCaseImplementation(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerById deleteCustomerById
    ) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.deleteCustomerById = deleteCustomerById;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdUseCase.find(id);

        deleteCustomerById.delete(id);
    }
}
