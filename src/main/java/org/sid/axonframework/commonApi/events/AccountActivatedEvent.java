package org.sid.axonframework.commonApi.events;

import lombok.Getter;
import org.sid.axonframework.commonApi.enums.AccountStatus;

@Getter
public class AccountActivatedEvent extends BasedEvent<String> {
    private AccountStatus status;
    public AccountActivatedEvent(String id, AccountStatus status) {
        super(id);
        this.status = status;
    }
}
