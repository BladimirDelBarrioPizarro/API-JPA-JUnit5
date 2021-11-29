package com.example.demo.model.entity;

import com.example.demo.model.entity.dummy.AccountDummy;
import com.example.demo.model.exceptions.HandleExceptionDevit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountTest {
    Account account1;
    Account account2;

    @BeforeEach
    void initTest(TestInfo testInfo, TestReporter testReporter){
      this.account1 =  AccountDummy.accountDummy1();
      this.account2 = AccountDummy.accountDummy2();
      log.info("Init test -> BeforeEach");
      log.info("Running: {} with Method: {} with Tag {}",testInfo.getDisplayName(),testInfo.getTestMethod().get().getName(),testInfo.getTags());
      testReporter.publishEntry("Running :"+testInfo.getDisplayName()+ "with Method :"+testInfo.getTestMethod().get().getName()+"with Tag :"+testInfo.getTags());
    }

    @AfterEach
    void endTest(){
        log.info("End test -> AfterEach");
    }

    @BeforeAll
    static void beforeAll(){
        log.info("Init test -> BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        log.info("End test -> AfterAll");
    }


    @Tag("parametrized")
    @Nested
    @DisplayName("Example test Parametrized")
    class Parametrized {
        Account account1;
        Account account2;

        @BeforeEach
        void initTest(){
            this.account1 =  AccountDummy.accountDummy1();
            this.account2 = AccountDummy.accountDummy2();
            log.info("Init test -> BeforeEach");
        }

        @DisplayName("Basic Test example parameterized")
        @ParameterizedTest
        @ValueSource(strings = {
                "first", "second"
        })
        void testSimple(String s) {
            assertFalse(s.isEmpty());
        }

        // Para testear decimales se recomienda strings ya que es más preciso
        @ParameterizedTest(name = "Number {index} execute with value {0} - {argumentsWithNames}")
        @ValueSource(strings = {"0.100","0.900","2.000"})
        void testExampleParametrized(String mount) {
            this.account2.setSubstractDevit(new BigDecimal(mount));
            assertNotNull(account2.getBalance());
            assertTrue(account2.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Number {index} execute with value {0} - {argumentsWithNames}")
        @CsvSource({"1,0.100","2,0.900","3,2.000"}) // Adjuntamos el indice seguido de una coma y el valor
        void testExampleParametrizedCsv(String index, String mount) {
            log.info(index + "-> "+mount);
            this.account2.setSubstractDevit(new BigDecimal(mount));
            assertNotNull(account2.getBalance());
            assertTrue(account2.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Number {index} execute with value {0} - {argumentsWithNames}")
        @CsvSource({"200,100,Javier,Frodo","300,200,Javier,Pepe","410,400,Javier,Manolo"}) // Adjuntamos los dos valores
        void testExampleParametrizedCsv2(String balance, String amount, String expected, String current) {
            this.account2.setBalance(new BigDecimal(balance));
            this.account2.setSubstractDevit(new BigDecimal(amount));
            assertEquals(expected,this.account2.getPerson());
            assertNotEquals(current,this.account2.getPerson());
            assertNotNull(account2.getBalance());
            assertTrue(account2.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Number {index} execute with value {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv") // Adjuntamos el indice seguido de una coma y el valor
        void testExampleParametrizedCsvFile(String mount) {
            this.account2.setSubstractDevit(new BigDecimal(mount));
            assertNotNull(account2.getBalance());
            assertTrue(account2.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }
    }

    @ParameterizedTest(name = "Number {index} execute with value {0} - {argumentsWithNames}")
    @MethodSource("mountList") // Adjuntamos el indice seguido de una coma y el valor
    void testExampleParametrizedMethodSource(String mount) {
        this.account2.setSubstractDevit(new BigDecimal(mount));
        assertNotNull(account2.getBalance());
        assertTrue(account2.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    private static List<String> mountList() {
        return Arrays.asList("0.100","0.900","2.000");
    }

    @Tag("account")
    @Test
    @DisplayName("Test name Account")
    void testNameAccount(TestInfo testInfo, TestReporter testReporter) {
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