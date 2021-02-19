package com.anz.account.controller;

import com.anz.account.dao.TransactionRepository;
import com.anz.account.dao.UserRepository;
import com.anz.account.domain.Account;
import com.anz.account.domain.Transaction;
import com.anz.account.domain.User;
import com.anz.account.service.AccountService;
import com.anz.account.service.TransactionService;
import com.anz.account.vo.TransactionPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
class TransactionController {

    @Autowired AccountController accountController;
    @Autowired TransactionService transactionService;

    @GetMapping("/transactions/{userId}/{accountNumber}")
    List<TransactionPageVO> findByUserAndAccountNo(@PathVariable Long userId, @PathVariable Long accountNumber) {
        Account account = accountController.findByUserAndAccountNo(userId, accountNumber);
        if(account == null) {
            return null;
        }
        return transactionService.findByAccount(account);
    }
}