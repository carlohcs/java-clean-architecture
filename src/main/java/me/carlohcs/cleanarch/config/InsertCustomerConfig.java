package me.carlohcs.cleanarch.config;

import me.carlohcs.cleanarch.core.usecase.implementation.InsertCustomerUseCaseImplementation;
import me.carlohcs.cleanarch.dataprovider.FindAddressByZipCodeImplementation;
import me.carlohcs.cleanarch.dataprovider.InsertCustomerImplementation;
import me.carlohcs.cleanarch.dataprovider.SendCpfForValidationImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    // What is a Bean?
    @Bean
    public InsertCustomerUseCaseImplementation insertCustomerUseCase(
            FindAddressByZipCodeImplementation findAddressByZipCode,
            InsertCustomerImplementation insertCustomer,
            SendCpfForValidationImplementation sendCpfForValidationImplementation
    ) {
        return new InsertCustomerUseCaseImplementation(findAddressByZipCode, insertCustomer, sendCpfForValidationImplementation);
    }
}
