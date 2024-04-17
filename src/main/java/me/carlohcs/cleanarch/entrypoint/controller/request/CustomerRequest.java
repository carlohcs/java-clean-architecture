package me.carlohcs.cleanarch.entrypoint.controller.request;

import javax.validation.constraints.NotBlank;

// It creates the getters and setters
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String zipCode;
}
