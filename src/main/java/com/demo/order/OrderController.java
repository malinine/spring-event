package com.demo.order;

import com.demo.payment.PaymentEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.demo.payment.PaymentInfo;

import java.util.Optional;

@Controller
@Slf4j
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentEventPublisher paymentEventPublisher;

    @PostMapping(value = "/v1/order/{orderId}/payment")
    public ResponseEntity pay(@PathVariable String orderId, @RequestBody OrderPaymentRequest request) {

        log.info(" ===== Star order payment , order Id : [{}] =====", orderId);

        Optional<Order> orderOpt = orderRepository.findById(orderId);

        if (!orderOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        log.info("Perform payment transaction ... ");

        Order order = orderOpt.get();
        order.setStatus("paid");
        orderRepository.save(order);

        log.info("updated order status : paid");

        PaymentInfo paymentInfo = PaymentInfo.builder()
                .orderId(order.getId())
                .amount(order.getAmount())
                .userId(order.getUserId())
                .build();

        paymentEventPublisher.publishPaymentCreatedEvent(paymentInfo);

        log.info(" ===== End order payment =====");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
