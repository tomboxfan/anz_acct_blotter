package com.anz.account.dao;

import com.anz.account.domain.Account;
import com.anz.account.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByAccount(Account account);
}
