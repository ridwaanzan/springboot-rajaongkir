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
public class RajaOngkirCostDtoResponse implements Serializable {
    private static final long serialVersionUID = 5491144895081800468L;

    private ROCostDataDto rajaongkir;
}
