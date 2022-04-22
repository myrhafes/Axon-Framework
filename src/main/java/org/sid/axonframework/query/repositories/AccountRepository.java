package org.sid.axonframework.query.repositories;

import org.sid.axonframework.query.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
