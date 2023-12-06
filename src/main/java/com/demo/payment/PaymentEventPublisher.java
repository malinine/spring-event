package com.demo.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishPaymentCreatedEvent(PaymentInfo paymentInfo) {
        log.info("Start Publishing Payment created event");
        PaymentCreatedEvent paymentCreatedEvent = new PaymentCreatedEvent(this, paymentInfo);
        applicationEventPublisher.publishEvent(paymentCreatedEvent);
        log.info("End Publishing Payment created event");
    }
}
