package com.excercise.inteceptor.controllers;

import com.excercise.inteceptor.dto.ROCostResultDto;
import com.excercise.inteceptor.dto.RajaOngkirCostDtoRequest;
import com.excercise.inteceptor.dto.RajaOngkirCostDtoResponse;
import com.excercise.inteceptor.services.RajaOngkirService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class RajaOngkirController {
    @Autowired
    public RajaOngkirService rajaOngkirService;

    @PostMapping("/getcost")
    public List<ROCostResultDto> getShippingCost(@RequestBody RajaOngkirCostDtoRequest request) {
        return rajaOngkirService.getShippingCost(request);
    }
}
