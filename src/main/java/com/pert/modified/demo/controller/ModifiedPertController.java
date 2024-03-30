package com.pert.modified.demo.controller;

import com.pert.modified.demo.dto.request.CalculationRequest;
import com.pert.modified.demo.dto.response.CalculationResponse;
import com.pert.modified.demo.service.ModifiedPertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/modified-pert")
public class ModifiedPertController {
    private final ModifiedPertService modifiedPertService;

    @GetMapping("/calculate")
    public CalculationResponse calculateOperationsDuration(@RequestBody CalculationRequest calculationRequest) {
        return new CalculationResponse(modifiedPertService.calculateOperationsDuration(calculationRequest));
    }

}
