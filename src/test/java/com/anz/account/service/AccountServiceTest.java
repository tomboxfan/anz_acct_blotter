package com.anz.account.service;

import com.anz.account.ANZAccountApplication;
import com.anz.account.dao.UserRepository;
import com.anz.account.domain.Account;
import com.anz.account.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ANZAccountApplication.class)
public class AccountServiceTest {


    @Autowired UserRepository userRepository;
    @Autowired AccountService accountService;

    @Test
    public void testFindByUser() {
        User user = userRepository.findById(1l).get();
        List<Account> accountList = accountService.findByUser(user);
        System.out.println(accountList);

        assertEquals(2, accountList.size());
        assertEquals(585309209, accountList.get(0).getAccountNumber().longValue());
        assertEquals(791066619, accountList.get(1).getAccountNumber().longValue());
    }

}
