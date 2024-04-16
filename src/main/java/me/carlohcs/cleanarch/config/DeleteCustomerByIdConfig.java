package me.carlohcs.cleanarch.config;

import me.carlohcs.cleanarch.core.usecase.implementation.DeleteCustomerByIdUseCaseImplementation;
import me.carlohcs.cleanarch.core.usecase.implementation.FindCustomerByIdUseCaseImplementation;
import me.carlohcs.cleanarch.dataprovider.DeleteCustomerByIdImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCaseImplementation deleteCustomerByIdUseCase(
            FindCustomerByIdUseCaseImplementation findCustomerByIdUseCase,
            DeleteCustomerByIdImplementation deleteCustomerByIdId
    ) {
        return new DeleteCustomerByIdUseCaseImplementation(findCustomerByIdUseCase, deleteCustomerByIdId);
    }
}
