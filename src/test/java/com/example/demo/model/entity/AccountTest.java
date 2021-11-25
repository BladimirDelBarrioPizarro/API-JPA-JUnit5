package com.example.demo.model.entity;

import com.example.demo.model.entity.dummy.AccountDummy;
import com.example.demo.model.exceptions.HandleExceptionDevit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class AccountTest {
    Account account1;
    Account account2;

    @BeforeEach
    void initTest(){
      this.account1 =  AccountDummy.accountDummy1();
      this.account2 = AccountDummy.accountDummy2();
      log.info("Init test");
    }

    @AfterEach
    void endTest(){
        log.info("End test");
    }

    @Test
    @DisplayName("Test name Account")
    void testNameAccount() {
        String expected = "Bladimir";
        String reality = account1.getPerson();
        // Se crea la instancia del string no es recomendable por el consumo de recursos
        assertNotNull(account1,"The account cannot be null");
        // Se recomienda usar una lambda
        assertEquals(expected,reality, () -> "The account name is not what expected: Expected: "+expected);
        assertTrue(account1.getPerson().equals(expected));
    }

    @Test
    @DisplayName("Test balance Account")
    void testBalanceAccount() {
        assertEquals(1000.434,account1.getBalance().doubleValue());
        assertFalse(account1.getBalance().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(account1.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("Test Dummy Account") // Desabilita el método en la ejecución
    @Disabled
    void testReferenceAccount() {
        Account account1 =  AccountDummy.accountDummy1();
        Account account2 =  AccountDummy.accountDummy1();
        assertEquals(account1,account2);
        // assertNotEquals(account1,account2);
    }

    @Test
    @DisplayName("Test method setSumDevit Account")
    void testSetSumDebitAccount() {
        // fail(); // Con fail fozamos el fallo del método
        this.account2.setSumDevit(new BigDecimal("1.100"));
        assertNotNull(this.account2.getBalance());
        assertEquals("2.200",account2.getBalance().toString());
        assertEquals(2.0,account2.getBalance().intValue());
    }

    @Test
    @DisplayName("Test method setSubstractDevit Account")
    void testSubstractDevitAccount() {
        this.account2.setSubstractDevit(new BigDecimal("1.100"));
        assertNotNull(this.account2.getBalance());
        assertEquals("0.000",this.account2.getBalance().toPlainString());
        assertEquals(0.0,this.account2.getBalance().intValue());
    }

    @Test
    @DisplayName("Test exception HandleExceptionDevit Account")
    void testHandleExceptionDevitAccount() {
        Exception exception = assertThrows(HandleExceptionDevit.class, () -> {
           this.account2.setSubstractDevit(new BigDecimal("2.200"));
        });
        String message = exception.getMessage();
        String expected = "Insufficient Money";
        assertEquals(message,expected);
    }
}