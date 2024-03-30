package com.pert.modified.demo.calculator.impl;

import com.pert.modified.demo.calculator.ModifiedPertCalculator;
import com.pert.modified.demo.dto.request.OperationMetadata;
import com.pert.modified.demo.dto.request.OperationScenario;
import com.pert.modified.demo.dto.response.CalculatedOperationEstimation;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;

@Component
public class ModifiedPertCalculatorImpl implements ModifiedPertCalculator {

    @Override
    public CalculatedOperationEstimation calculateOperationEstimation(OperationMetadata operationMetadata) {
        var estimates = operationMetadata.getEstimates();

        var optimisticEstimation = estimates.get(OperationScenario.OPTIMISTIC);
        var optimisticDuration = optimisticEstimation.getDuration();
        var optimisticInfluence = optimisticEstimation.getInfluence();

        var pessimisticEstimation = estimates.get(OperationScenario.PESSIMISTIC);
        var pessimisticDuration = pessimisticEstimation.getDuration();
        var pessimisticInfluence = pessimisticEstimation.getInfluence();

        var expectedEstimation = estimates.get(OperationScenario.EXPECTED);
        var expectedDuration = expectedEstimation.getDuration();
        var expectedInfluence = expectedEstimation.getInfluence();

        var optimisticValue = optimisticDuration.multiply(optimisticInfluence);
        var pessimisticValue = pessimisticDuration.multiply(pessimisticInfluence);
        var expectedValue = expectedDuration.multiply(expectedInfluence);

        var result = optimisticValue.add(pessimisticValue).add(expectedValue)
                .divide(optimisticInfluence.add(pessimisticInfluence).add(expectedInfluence), RoundingMode.CEILING);

        return CalculatedOperationEstimation.builder()
                .operationId(operationMetadata.getOperationId())
                .operationName(operationMetadata.getOperationName())
                .duration(result)
                .build();
    }
}
