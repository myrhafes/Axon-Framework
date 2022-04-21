package org.sid.axonframework.commonApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreateAccounRequestDTO {
    private double intialBalance;
    private String currency;
}
