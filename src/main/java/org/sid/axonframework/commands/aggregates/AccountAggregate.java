package org.sid.axonframework.commands.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.axonframework.commonApi.commands.CreateAccountCommand;
import org.sid.axonframework.commonApi.commands.CreditAccountCommand;
import org.sid.axonframework.commonApi.commands.DebitAccountCommand;
import org.sid.axonframework.commonApi.enums.AccountStatus;
import org.sid.axonframework.commonApi.events.AccountActivatedEvent;
import org.sid.axonframework.commonApi.events.AccountCreatedEvent;
import org.sid.axonframework.commonApi.events.AccountCreditedEvent;
import org.sid.axonframework.commonApi.events.AccountDebitedEvent;

@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public AccountAggregate() {
        //Required by AXON
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        if (command.getInitialBalance() < 0) throw new RuntimeException("Impossible de créer un compte avec solde negative");
        AggregateLifecycle.apply(new AccountCreatedEvent(
                command.getId(),
                command.getInitialBalance(),
                command.getCurrency(),
                AccountStatus.CREATED
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        this.accountId = event.getId();
        this.balance = event.getInitialBalance();
        this.currency = event.getCurrency();
        this.status = AccountStatus.CREATED;
        AggregateLifecycle.apply(new AccountActivatedEvent(
                event.getId(),
                AccountStatus.ACTIVATED
        ));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent event) {
        this.status = event.getStatus();
    }

    @CommandHandler
    public void handle(CreditAccountCommand command) {
        if(command.getAmount() <= 0) throw new RuntimeException("Amount is < 0 !");
        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getId(),
                command.getAmount(),
                command.getCurrency()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent event) {
        this.balance += event.getAmount();
    }

    @CommandHandler
    public void handle(DebitAccountCommand command) {
        if(command.getAmount() <= 0) throw new RuntimeException("Amount is < 0 !");
        if(this.balance < command.getAmount()) throw new RuntimeException("Balance ...");
        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getId(),
                command.getAmount(),
                command.getCurrency()
        ));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent event) {
        this.balance -= event.getAmount();
    }
}
