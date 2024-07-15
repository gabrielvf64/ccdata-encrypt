package com.gabrielvicente.cryptography_challenge.repository;

import com.gabrielvicente.cryptography_challenge.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
