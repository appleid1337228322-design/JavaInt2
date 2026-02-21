package ru.project.dao;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserDaoIntegrationTest {

    private PostgreSQLContainer<?> postgres;

    @BeforeAll
    void start() {
        postgres = new PostgreSQLContainer<>("postgres:15")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");
        postgres.start();
    }

    @AfterAll
    void stop() {
        postgres.stop();
    }

    @Test
    void containerShouldStart() {
        assertTrue(postgres.isRunning());
    }
}
