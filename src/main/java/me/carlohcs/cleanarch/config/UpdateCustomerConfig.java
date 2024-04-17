package me.carlohcs.cleanarch.config;

import me.carlohcs.cleanarch.core.usecase.implementation.FindCustomerByIdUseCaseImplementation;
import me.carlohcs.cleanarch.core.usecase.implementation.UpdateCustomerUseCaseImplementation;
import me.carlohcs.cleanarch.dataprovider.FindAddressByZipCodeImplementation;
import me.carlohcs.cleanarch.dataprovider.UpdateCustomerImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImplementation updateCustomerUseCase(
        FindCustomerByIdUseCaseImplementation findCustomerByIdUseCase,
        FindAddressByZipCodeImplementation findAddressByZipCode,
        UpdateCustomerImplementation updateCustomer
    ) {
        return new UpdateCustomerUseCaseImplementation(findCustomerByIdUseCase, findAddressByZipCode, updateCustomer);
    }
}
