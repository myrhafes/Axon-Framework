package org.sid.axonframework.commonApi.events;

import lombok.Getter;

@Getter
public class AccountDebitedEvent extends BasedEvent<String>{
    private double amount;
    private String currency;

    public AccountDebitedEvent(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
