package com.excercise.inteceptor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ROCostDataDto implements Serializable {
    private static final long serialVersionUID = 7126165485933475195L;

    private List<ROCostResultDto> results;
}
