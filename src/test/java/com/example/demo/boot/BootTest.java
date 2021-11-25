package com.example.demo.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.springframework.boot.system.SystemProperties;

import java.util.Map;
import java.util.Properties;

@Slf4j
public class BootTest {

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
    @DisabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE", matches = "AMD64")
    void testEnvironmentDisabledProcessor() {
        log.info("Run if processor architecture is not AMD64");
    }
}
