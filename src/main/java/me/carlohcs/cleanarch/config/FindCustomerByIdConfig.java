package me.carlohcs.cleanarch.config;


import me.carlohcs.cleanarch.core.usecase.implementation.FindCustomerByIdUseCaseImplementation;
import me.carlohcs.cleanarch.dataprovider.FindCustomerByIdImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCaseImplementation findCustomerByIdUseCase(
            FindCustomerByIdImplementation findCustomerById
    ) {
        return new FindCustomerByIdUseCaseImplementation(findCustomerById);
    }
}
