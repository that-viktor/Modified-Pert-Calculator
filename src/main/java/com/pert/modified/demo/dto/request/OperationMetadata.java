package com.pert.modified.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationMetadata {
    @NotNull
    private String operationId;
    private String operationName;
    @NotNull
    private Map<OperationScenario, OperationEstimation> estimates;
}
