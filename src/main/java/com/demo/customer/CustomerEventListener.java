package com.demo.customer;


import com.demo.payment.PaymentCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerEventListener  {

    @EventListener
    public void updateCustomerReward(PaymentCreatedEvent event) {
        log.info("== Start updating Rewards ==");

        log.info("add reward point to user Id : [{}]", event.getMessage().getUserId());

        log.info("== End updating Rewards ==");
    }
}
