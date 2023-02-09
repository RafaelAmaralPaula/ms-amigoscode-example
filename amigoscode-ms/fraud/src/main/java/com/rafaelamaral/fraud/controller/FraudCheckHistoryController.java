package com.rafaelamaral.fraud.controller;

import com.rafaelamaral.fraud.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/frauds")
@AllArgsConstructor
public class FraudCheckHistoryController{
    private final FraudCheckHistoryService fraudService;
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        var isFradulentCustomer = fraudService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}" , customerId);
        return new FraudCheckResponse(isFradulentCustomer);
    }

}