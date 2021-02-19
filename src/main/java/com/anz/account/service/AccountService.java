package com.anz.account.service;

import com.anz.account.dao.AccountRepository;
import com.anz.account.domain.Account;
import com.anz.account.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired AccountRepository accountRepository;

    public List<Account> findByUser(User user) {
        return accountRepository.findByUser(user);
    }

}
