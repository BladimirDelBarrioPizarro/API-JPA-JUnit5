package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    public String name;
    private List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account){
        accountList.add(account);
    }

    public void transfer(Account origin, Account destiny, BigDecimal devit) {
        origin.setSubstractDevit(devit);
        destiny.setSumDevit(devit);
    }
}
