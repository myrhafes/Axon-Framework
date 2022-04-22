package org.sid.axonframework.query.repositories;

import org.sid.axonframework.query.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
