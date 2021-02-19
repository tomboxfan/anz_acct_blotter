package com.anz.account.vo;

import com.anz.account.domain.Account;
import com.anz.account.domain.Transaction;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionPageVO {

    Long accountNumber;
    String accountName;
    LocalDate valueDate;
    String currency;
    Double debitAmount;
    Double creditAmount;
    String debitCredit;
    String transactionNarrative;

    public TransactionPageVO(Account acct, Transaction trac) {
        this.accountNumber = acct.getAccountNumber();
        this.accountName = acct.getAccountName();
        this.valueDate = trac.getValueDate();
        this.currency = acct.getCurrency();
        this.debitAmount = trac.getDebitAmount();
        this.creditAmount = trac.getCreditAmount();
        this.debitCredit = trac.getDebitCredit();
        this.transactionNarrative = trac.getTransactionNarrative();
    }
}
