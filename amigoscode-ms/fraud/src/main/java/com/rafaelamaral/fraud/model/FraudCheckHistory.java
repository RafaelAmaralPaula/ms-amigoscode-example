package com.rafaelamaral.fraud.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_fraud")
@Data
@Builder
public class FraudCheckHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "is_fraudster")
    private Boolean isFraudster;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
