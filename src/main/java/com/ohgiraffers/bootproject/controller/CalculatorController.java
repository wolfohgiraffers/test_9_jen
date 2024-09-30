package com.ohgiraffers.bootproject.controller;

import com.ohgiraffers.bootproject.dto.CalculatorDTO;
import com.ohgiraffers.bootproject.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health")
    public String health() {
        return "I'm OK!";
    }

    @GetMapping("/plus")
    public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO calculatorDTO) {
        log.debug("plus 핸들러 실행여부 확인");
        log.debug("jenkins pipeline 확인");
        int result = calculatorService.plusTwoNumbers(calculatorDTO);

        calculatorDTO.setSum(result);

        return ResponseEntity
                .ok()
                .body(calculatorDTO);
    }
}
