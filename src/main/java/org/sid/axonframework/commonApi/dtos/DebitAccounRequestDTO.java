package org.sid.axonframework.commonApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitAccounRequestDTO {
    private String accountId;
    private double amount;
    private String currency;
}
