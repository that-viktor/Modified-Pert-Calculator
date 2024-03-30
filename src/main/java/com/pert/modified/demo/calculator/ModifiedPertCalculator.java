package com.pert.modified.demo.calculator;

import com.pert.modified.demo.dto.request.OperationMetadata;
import com.pert.modified.demo.dto.response.CalculatedOperationEstimation;

public interface ModifiedPertCalculator {

   CalculatedOperationEstimation calculateOperationEstimation(OperationMetadata operationMetadata);
}
