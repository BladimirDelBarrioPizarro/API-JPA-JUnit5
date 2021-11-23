package com.example.demo.model.entity;

import com.example.demo.model.entity.dummy.AccountDummy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void testTransferBank() {
       Account origin = AccountDummy.accountDummy3();
       Account destiny = AccountDummy.accountDummy4();

       Bank bank = new Bank();
       bank.transfer(origin,destiny,new BigDecimal(300));
       assertEquals("200",origin.getBalance().toPlainString());
       assertEquals("1800",destiny.getBalance().toPlainString());
    }

    @Test
    void testAddAccountBank() {
        Bank bank = new Bank();
        Account account1 = AccountDummy.accountDummy1();
        Account account2 = AccountDummy.accountDummy2();
        bank.addAccount(account1);
        bank.addAccount(account2);
        assertEquals(2,bank.getAccountList().size());
    }

}