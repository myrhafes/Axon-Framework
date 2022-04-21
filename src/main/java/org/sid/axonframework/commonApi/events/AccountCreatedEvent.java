package org.sid.axonframework.commonApi.events;

import lombok.Getter;

@Getter
public class AccountCreatedEvent extends BasedEvent<String>{
    private double initialBalance;
    private String currency;
    public AccountCreatedEvent(String id, double initialBalance, String currency) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
    }
}
