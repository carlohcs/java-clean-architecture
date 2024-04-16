package me.carlohcs.cleanarch.entrypoint.controller.mapper;

import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.entrypoint.controller.request.CustomerRequest;
import me.carlohcs.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
