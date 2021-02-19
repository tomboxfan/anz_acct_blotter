package com.anz.account.service;


import com.anz.account.ANZAccountApplication;
import com.anz.account.dao.AccountRepository;
import com.anz.account.dao.UserRepository;
import com.anz.account.domain.Account;
import com.anz.account.domain.Transaction;
import com.anz.account.domain.User;
import com.anz.account.vo.TransactionPageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ANZAccountApplication.class)
public class TransactionServiceTest {

    @Autowired UserRepository userRepository;
    @Autowired AccountRepository accountRepository;
    @Autowired TransactionService transactionService;

    @Test
    public void testFindByAccount() {
        User user = userRepository.findById(1l).get();
        List<Account> accountList = accountRepository.findByUser(user);
        List<TransactionPageVO> transactionList = transactionService.findByAccount(accountList.get(0));
        System.out.println(transactionList);

        assertEquals(2, transactionList.size());
        assertEquals("Credit Card Payment", transactionList.get(0).getTransactionNarrative());
        assertEquals("Salary", transactionList.get(1).getTransactionNarrative());
    }


}
