package com.demo.notification;

import com.demo.payment.PaymentCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailEventListener {

    @EventListener
    public void sendOrderPaymentEmail(PaymentCreatedEvent event) {
        log.info("== Start sending Email ==");

        log.info("Send email Payment success to user Id : [{}]", event.getMessage().getUserId());

        log.info("== End sending Email ==");
    }
}
