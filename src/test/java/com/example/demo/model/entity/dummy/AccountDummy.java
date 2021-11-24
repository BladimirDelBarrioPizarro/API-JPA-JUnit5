package com.example.demo.model.entity.dummy;

import com.example.demo.model.entity.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccountDummy {

    public static Account accountDummy1() {
        return  Account.builder()
                .person("Bladimir")
                .balance(new BigDecimal("1000.434"))
                // .bank()
                .build();
    }


    public static Account accountDummy2() {
        return  Account.builder()
                .person("Javier")
                .balance(new BigDecimal("1.100"))
                .bank(BankDummy.bankDummy1())
                .build();
    }

    public static Account accountDummy3() {
        return  Account.builder()
                .person("Maria")
                .balance(new BigDecimal("500"))
                // .bank()
                .build();
    }

    public static Account accountDummy4() {
        return  Account.builder()
                .person("Luis")
                .balance(new BigDecimal("1500"))
                // .bank()
                .build();
    }
}
