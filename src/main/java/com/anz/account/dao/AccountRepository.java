package com.anz.account.dao;

import com.anz.account.domain.Account;
import com.anz.account.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByUser(User user);
    Account findByAccountNumber(Long accountNumber);
}
