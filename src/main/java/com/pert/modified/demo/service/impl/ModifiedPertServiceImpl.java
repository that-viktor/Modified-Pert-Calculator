package com.pert.modified.demo.service.impl;

import com.pert.modified.demo.calculator.ModifiedPertCalculator;
import com.pert.modified.demo.dto.request.CalculationRequest;
import com.pert.modified.demo.dto.response.CalculatedOperationEstimation;
import com.pert.modified.demo.service.ModifiedPertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModifiedPertServiceImpl implements ModifiedPertService {

    private final ModifiedPertCalculator modifiedPertCalculator;

    @Override
    public List<CalculatedOperationEstimation> calculateOperationsDuration(CalculationRequest calculationRequest) {
        return calculationRequest.getOperations()
                .stream()
                .map(modifiedPertCalculator::calculateOperationEstimation)
                .toList();
    }

}
