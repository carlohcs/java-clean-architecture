package me.carlohcs.cleanarch.dataprovider.client.mapper;

import me.carlohcs.cleanarch.core.domain.Address;
import me.carlohcs.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
