package me.carlohcs.cleanarch.core.usecase.implementation;

import me.carlohcs.cleanarch.core.dataprovider.FindAddressByZipCode;
import me.carlohcs.cleanarch.core.dataprovider.InsertCustomer;
import me.carlohcs.cleanarch.core.dataprovider.SendCpfForValidation;
import me.carlohcs.cleanarch.core.domain.Address;
import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImplementation implements InsertCustomerUseCase {
    // The idea of "final" aims to preserve immutability of a property/class/methods
    // https://pt.stackoverflow.com/questions/17015/qual-o-uso-de-uma-vari%C3%A1vel-est%C3%A1tica-ou-final-em-java
    private final FindAddressByZipCode findAddressByZipCode;

    private final InsertCustomer insertCustomer;

    private final SendCpfForValidation sendCpfForValidation;

    public InsertCustomerUseCaseImplementation(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer,
            SendCpfForValidation sendCpfForValidation) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpfForValidation = sendCpfForValidation;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        // YES, Java has 'var' as JavaScript.
        // So you don't need to define specifically what is
        // so Java can infer what is the return (like TS usually does)
        // https://www.linkedin.com/pulse/var-keyword-java-darcy-declute/
        // you can define:
        // var address = findAddressByZipCode.find(zipCode);
        Address address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);

        insertCustomer.insert(customer);

        sendCpfForValidation.send(customer.getCpf());
    }
}
