package com.example.demo.model.entity.dummy;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BankDummy {

    public static Bank bankDummy1() {
        return  Bank.builder()
                .name("ING")
                .accountList(new ArrayList<>())
                .build();
    }
}
