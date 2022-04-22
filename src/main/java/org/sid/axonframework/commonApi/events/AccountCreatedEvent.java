package org.sid.axonframework.commonApi.events;

import lombok.Getter;
import org.sid.axonframework.commonApi.enums.AccountStatus;

@Getter
public class AccountCreatedEvent extends BasedEvent<String>{
    private double initialBalance;
    private String currency;
    private AccountStatus status;

    public AccountCreatedEvent(String id, double initialBalance, String currency, AccountStatus status) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
        this.status = status;
    }
}
