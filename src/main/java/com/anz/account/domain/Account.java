package com.anz.account.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Account extends BaseEntity {

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="userId")
    @Getter @Setter private User user;
    @Getter @Setter private Long accountNumber;
    @Getter @Setter private String accountName;
    @Getter @Setter private String accountType;
    @Getter @Setter private LocalDate balanceDate;
    @Getter @Setter private String currency;
    @Getter @Setter private Double openingAvailableBalance;


    @JsonBackReference
    @OneToMany(mappedBy="account")
    @Getter @Setter private List<Transaction> transactionList = new LinkedList<>();

    @Override public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append("accountNumber", accountNumber)
                .append("accountName", accountName)
                .append("accountType", accountType)
                .append("balanceDate", balanceDate)
                .append("currency", currency)
                .append("openingAvailableBalance", openingAvailableBalance)
                .toString();
    }


}
