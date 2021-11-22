package com.example.demo.model.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void testNameAccount() {
        Account account = new Account("Bladimir", new BigDecimal("1000.434"));
        String expected = "Bladimir";
        String reality = account.getPerson();
        assertEquals(expected,reality);
        assertTrue(account.getPerson().equals(expected));
    }

    @Test
    void testBalanceAccount() {
        Account account =  new Account("Bladimir", new BigDecimal("1000.434"));
        assertEquals(1000.434,account.getBalance().doubleValue());
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenceAccount() {
        Account account1 =  new Account("Bladimir", new BigDecimal("1000.434"));
        Account account2 =  new Account("Bladimir", new BigDecimal("1000.434"));
        assertEquals(account1,account2);
        // assertNotEquals(account1,account2);
    }

    @Test
    void testSetSumDebitAccount() {
        Account account1 =  new Account("Bladimir", new BigDecimal("1.100"));
        account1.setSumDevit(new BigDecimal("1.100"));
        assertNotNull(account1.getBalance());
        assertEquals("2.200",account1.getBalance().toString());
        assertEquals(2.0,account1.getBalance().intValue());
    }

    @Test
    void testSubstractDevitAccount() {
        Account account1 =  new Account("Bladimir", new BigDecimal("1.100"));
        account1.setSubstractDevit(new BigDecimal("1.100"));
        assertNotNull(account1.getBalance());
        assertEquals("0.000",account1.getBalance().toPlainString());
        assertEquals(0.0,account1.getBalance().intValue());
    }
}