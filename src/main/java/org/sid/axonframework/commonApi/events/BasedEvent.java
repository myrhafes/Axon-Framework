package org.sid.axonframework.commonApi.events;

import lombok.Getter;

@Getter
public abstract class BasedEvent<T>{
    private T id;

    public BasedEvent(T id) {
        this.id = id;
    }
}
