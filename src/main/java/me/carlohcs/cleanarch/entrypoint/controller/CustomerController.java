package me.carlohcs.cleanarch.entrypoint.controller;

import me.carlohcs.cleanarch.core.domain.Customer;
import me.carlohcs.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import me.carlohcs.cleanarch.core.usecase.FindCustomerByIdUseCase;
import me.carlohcs.cleanarch.core.usecase.InsertCustomerUseCase;
import me.carlohcs.cleanarch.core.usecase.UpdateCustomerUseCase;
import me.carlohcs.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import me.carlohcs.cleanarch.entrypoint.controller.request.CustomerRequest;
import me.carlohcs.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);

        // Lombok is not generating getter and setter
        // https://stackoverflow.com/a/49180270
        // solution: install "Lombok" plugin inside of IntelliJ
        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdUseCase.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);

        customer.setId(id);

        updateCustomerUseCase.update(customer, customerRequest.getZipCode());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdUseCase.delete(id);

        return ResponseEntity.noContent().build();
    }

}
