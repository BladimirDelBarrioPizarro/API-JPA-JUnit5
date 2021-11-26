package com.example.demo.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assumptions.*;

@Slf4j
public class BootTest {

    @Nested
    @DisplayName("Test battery for OS")
    class OSTest {
        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testOnlyWindows() {
            log.info("Runs only on Windows operating systems");
        }

        @Test
        @EnabledOnOs({OS.LINUX,OS.MAC})
        void testOnlyLinuxAndMac() {
            log.info("Runs only on Linux operating systems");
        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
        void testDisabledWindows() {
            log.info("Does not run on Windows operating systems");
        }
    }

    @Nested
    @DisplayName("Test battery for Java version")
    class JavaVersion {
        @Test
        @EnabledOnJre(JRE.JAVA_17)
        void testEnabledJava17() {
            log.info("Runs only Java17");
        }

        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void testEnabledJava8() {
            log.info("Runs only Java8");
        }

        @Test
        @DisabledOnJre(JRE.JAVA_17)
        void testDisabledJava17() {
            log.info("Disabled for Java 17");
        }
    }


    @Nested
    @DisplayName("Test battery for System Properties")
    class SystemProperties {
        @Test
        void testPrintSystemProperties(){
            Properties properties = System.getProperties();
            properties.forEach((key,value) -> log.info("Key: {} -> Value: {}",key,value.toString()));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "17.*")
        void testEnabledIfSystemProperty(){
            log.info("It only runs if the java version is 17");
        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "DEV")
        void testEnabledEnv(){
            log.info("Run if environment variable is DEV");
        }

        @Test
        @DisabledIfSystemProperty(named = "java.version", matches = "17.*")
        void testDisabledIfSystemProperty() {
            log.info("Does not run if the java version is 17");
        }
    }

   @Nested
   @DisplayName("Test battery for System Environment")
   class SystemEnvironment {
       @Test
       void testPrintSystemEnvironment() {
           Map<String, String> getenv  = System.getenv();
           getenv.entrySet().forEach(System.out::println);
       }

       @Test
       @EnabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE", matches = "AMD64")
       void testEnvironmentEnableProcessor() {
           log.info("Run if processor architecture is AMD64");
       }

       @Test
       @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "DEV")
       void testEnvironmentVariable() {
           log.info("Run if ENVIRONMENT is DEV");
       }

       @Test
       @DisabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE", matches = "AMD64")
       void testEnvironmentDisabledProcessor() {
           log.info("Run if processor architecture is not AMD64");
       }
   }



    @Test
    @DisplayName("Assumption example with conditional TRUE")
    void testAssumeTrue(){
        boolean isDev = "DEV".equals(System.getProperty("DEV"));
        assumeTrue(isDev);
        log.info("Execute if the assumptions condition is met");
    }

    @Test
    @DisplayName("Assumption example with conditional FALSE")
    void testAssumeFalse(){
        boolean isDev = "DEV".equals(System.getProperty("DEV"));
        assumeFalse(isDev);
        log.info("Execute if the assumptions condition is not met");
        assumingThat(isDev, () -> {
            log.info("Execute if the assumptions condition is met");
        });
    }

    @RepeatedTest(value = 3,name = "{displayName} -> Repetition number {currentRepetition} of {totalRepetitions}")
    @DisplayName("Example tag RepeatedTest")
    void testRepeated(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 2) {
            log.info("Run this snippet on repeat two");
        }
        log.info("This test has to be repeated three times");
    }
}
