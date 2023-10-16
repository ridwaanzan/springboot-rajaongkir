package com.excercise.inteceptor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RajaOngkirCostDtoRequest implements Serializable {
    private static final long serialVersionUID = -6461109587196597516L;

    private String origin;
    private String destination;
    private Integer weight;
    private String courier;
}
