package com.excercise.inteceptor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ROCostDetailDto implements Serializable {
    private static final long serialVersionUID = -5961635601123298142L;

    private String service;
    private String description;
    private List<ROCostValueDto> cost;
}
