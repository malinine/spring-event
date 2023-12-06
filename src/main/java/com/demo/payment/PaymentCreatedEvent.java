package com.demo.payment;

import org.springframework.context.ApplicationEvent;

public class PaymentCreatedEvent extends ApplicationEvent {

    private PaymentInfo paymentInfo;

    public PaymentCreatedEvent(Object source, PaymentInfo paymentInfo) {
        super(source);
        this.paymentInfo = paymentInfo;
    }

    public PaymentInfo getMessage() {
        return this.paymentInfo;
    }
}
