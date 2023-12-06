package com.demo.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderPaymentRequest {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("payment_channel")
    private String paymentChannel;
}
