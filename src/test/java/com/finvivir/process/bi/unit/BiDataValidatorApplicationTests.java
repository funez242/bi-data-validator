package com.finvivir.process.bi.unit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Main test Class
 */

@TestPropertySource(properties = {"TOOLFIAPP-BACKEND_SERVICE_URL=http://localhost:8080"})
@SpringBootTest
class BiDataValidatorApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true); // its only check that context to be loaded correctly
    }
}
