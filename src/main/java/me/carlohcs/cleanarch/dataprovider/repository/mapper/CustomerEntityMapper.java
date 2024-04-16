package me.carlohcs.cleanarch.dataprovider.repository.mapper;


import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
