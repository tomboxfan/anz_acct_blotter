package com.anz.account.controller;

import com.anz.account.dao.AccountRepository;
import com.anz.account.dao.UserRepository;
import com.anz.account.domain.Account;
import com.anz.account.domain.User;
import com.anz.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
class AccountController {

    @Autowired AccountService accountService;
    @Autowired UserRepository userRepository;
    @Autowired AccountRepository accountRepository;

    @GetMapping("/accounts/{userId}")
    List<Account> findByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId).get();
        return accountService.findByUser(user);
    }

    @GetMapping("/accounts/{userId}/{accountNumber}")
    Account findByUserAndAccountNo(@PathVariable Long userId, @PathVariable Long accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account.getUser().getId() == userId) {
            return account;
        }
        return null;
    }
}