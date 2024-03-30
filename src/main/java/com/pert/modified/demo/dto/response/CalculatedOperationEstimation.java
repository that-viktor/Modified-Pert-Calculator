package com.pert.modified.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculatedOperationEstimation {
    private String operationId;
    private String operationName;
    private BigDecimal duration;
}
