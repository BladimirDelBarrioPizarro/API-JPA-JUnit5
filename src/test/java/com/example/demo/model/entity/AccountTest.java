package com.example.demo.model.entity;

import com.example.demo.model.entity.dummy.AccountDummy;
import com.example.demo.model.exceptions.HandleExceptionDevit;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void testNameAccount() {
        Account account = AccountDummy.accountDummy1();
        String expected = "Bladimi";
        String reality = account.getPerson();
        // Se crea la instancia del string no es recomendable por el consumo de recursos
        assertNotNull(account,"The account cannot be null");
        // Se recomienda usar una lambda
        assertEquals(expected,reality, () -> "The account name is not what expected: Expected: "+expected);
        assertTrue(account.getPerson().equals(expected));
    }

    @Test
    void testBalanceAccount() {
        Account account = AccountDummy.accountDummy1();
        assertEquals(1000.434,account.getBalance().doubleValue());
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenceAccount() {
        Account account1 =  AccountDummy.accountDummy1();
        Account account2 =  AccountDummy.accountDummy1();
        assertEquals(account1,account2);
        // assertNotEquals(account1,account2);
    }

    @Test
    void testSetSumDebitAccount() {
        Account account1 =  AccountDummy.accountDummy2();
        account1.setSumDevit(new BigDecimal("1.100"));
        assertNotNull(account1.getBalance());
        assertEquals("2.200",account1.getBalance().toString());
        assertEquals(2.0,account1.getBalance().intValue());
    }

    @Test
    void testSubstractDevitAccount() {
        Account account1 =  AccountDummy.accountDummy2();
        account1.setSubstractDevit(new BigDecimal("1.100"));
        assertNotNull(account1.getBalance());
        assertEquals("0.000",account1.getBalance().toPlainString());
        assertEquals(0.0,account1.getBalance().intValue());
    }

    @Test
    void testHandleExceptionDevitAccount() {
        Account account1 =  AccountDummy.accountDummy2();
        Exception exception = assertThrows(HandleExceptionDevit.class, () -> {
           account1.setSubstractDevit(new BigDecimal("2.200"));
        });
        String message = exception.getMessage();
        String expected = "Insufficient Money";
        assertEquals(message,expected);
    }
}