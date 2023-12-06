package com.demo.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "`order`")
public class Order {

    @Id
    private String id;
    private String userId;
    private Integer amount;
    private String status;
}
