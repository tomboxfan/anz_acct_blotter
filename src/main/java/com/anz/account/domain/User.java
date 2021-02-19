package com.anz.account.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
public class User extends BaseEntity {

    @Column
    @Getter @Setter private String name;

    @JsonBackReference
    @OneToMany(mappedBy="user")
    @Getter @Setter private List<Account> accountList = new LinkedList<>();

    @Override public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append("name", name)
                .toString();
    }

}
