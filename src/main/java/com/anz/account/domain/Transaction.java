package com.anz.account.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Transaction extends BaseEntity {

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="accountId")
    @Getter @Setter private Account account;

    @Getter @Setter private LocalDate valueDate;

    @Getter @Setter private Double debitAmount;
    @Getter @Setter private Double creditAmount;
    @Getter @Setter private String debitCredit;
    @Getter @Setter private String transactionNarrative;

    @Override public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append("valueDate", valueDate)
                .append("debitAmount", debitAmount)
                .append("creditAmount", creditAmount)
                .append("debitCredit", debitCredit)
                .append("transactionNarrative", transactionNarrative)
                .toString();
    }




}
