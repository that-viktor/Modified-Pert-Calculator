package com.pert.modified.demo.service;

import com.pert.modified.demo.dto.response.CalculatedOperationEstimation;
import com.pert.modified.demo.dto.request.CalculationRequest;

import java.util.List;

public interface ModifiedPertService {
    List<CalculatedOperationEstimation> calculateOperationsDuration(CalculationRequest calculationRequest);
}
