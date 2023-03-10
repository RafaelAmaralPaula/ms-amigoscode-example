package com.rafaelamaral.fraud.service;

import com.rafaelamaral.fraud.model.FraudCheckHistory;
import com.rafaelamaral.fraud.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckHistoryService{
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;


    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                                 .customerId(customerId)
                                 .isFraudster(false)
                                 .createdAt(LocalDateTime.now()
        ).build());

        return false;
    }



}
