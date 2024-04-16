package me.carlohcs.cleanarch.entrypoint.consumer;

import me.carlohcs.cleanarch.core.usecase.UpdateCustomerUseCase;
import me.carlohcs.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import me.carlohcs.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "carlohcs")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);

        updateCustomerUseCase.update(customer, customerMessage.getZipCode());
    }
}
