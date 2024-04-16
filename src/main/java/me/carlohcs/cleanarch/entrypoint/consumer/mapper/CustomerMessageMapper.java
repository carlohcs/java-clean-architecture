package me.carlohcs.cleanarch.entrypoint.consumer.mapper;

import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
