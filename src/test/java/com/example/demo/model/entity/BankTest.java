package com.example.demo.model.entity;

import com.example.demo.model.entity.dummy.AccountDummy;
import com.example.demo.model.entity.dummy.BankDummy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.stream.Collectors;

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
        Bank bank = BankDummy.bankDummy1();
        Account account1 = AccountDummy.accountDummy1();
        Account account2 = AccountDummy.accountDummy2();
        bank.addAccount(account1);
        bank.addAccount(account2);
        assertAll(() -> assertEquals(2,bank.getAccountList().size(),
                        () -> "This number of accounts is not expected"),
                  () -> assertEquals("ING",account2.getBank().getName()),
                  () -> assertEquals("Bladimir",bank.getAccountList().get(0).getPerson()),
                  () -> assertEquals("Bladimir",bank.getAccountList().stream()
                              .filter(account -> account.getPerson().equals("Bladimir"))
                              .findFirst()
                              .get()
                              .getPerson()),
                  () -> assertTrue(bank.getAccountList().stream()
                                      .filter(account -> account.getPerson().equals("Javier"))
                                      .findFirst()
                                      .isPresent()),
                  () -> assertTrue(bank.getAccountList().stream()
                                  .anyMatch(account -> account.getPerson().equals("Javier"))));
    }

}