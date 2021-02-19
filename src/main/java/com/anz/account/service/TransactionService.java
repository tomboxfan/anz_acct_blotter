package com.anz.account.service;

import com.anz.account.dao.TransactionRepository;
import com.anz.account.domain.Account;
import com.anz.account.domain.Transaction;
import com.anz.account.vo.TransactionPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired TransactionRepository transactionRepository;

    public List<TransactionPageVO> findByAccount(Account account) {
        List<Transaction> transactions = transactionRepository.findByAccount(account);
        return transactions.stream().map(trac -> new TransactionPageVO(account, trac)).collect(Collectors.toList());
    }

}
