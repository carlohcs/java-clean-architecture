package me.carlohcs.cleanarch.core.dataprovider;

import me.carlohcs.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {
    Address find(final String zipCode);
}
