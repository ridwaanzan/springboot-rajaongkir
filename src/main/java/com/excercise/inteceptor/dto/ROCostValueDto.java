package com.excercise.inteceptor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ROCostValueDto implements Serializable {
    private static final long serialVersionUID = -6876914893409986176L;

    private int value;
    private String etd;
    private String note;
}
