package me.carlohcs.cleanarch.dataprovider;

import me.carlohcs.cleanarch.core.dataprovider.FindAddressByZipCode;
import me.carlohcs.cleanarch.core.domain.Address;
import me.carlohcs.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import me.carlohcs.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImplementation implements FindAddressByZipCode {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);

        return addressResponseMapper.toAddress(addressResponse);
    }
}
