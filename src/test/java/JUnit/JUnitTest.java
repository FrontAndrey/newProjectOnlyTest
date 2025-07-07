package JUnit;

import org.junit.jupiter.api.*;

public class JUnitTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Это бефореОл>" );
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Это AfterОл>" );
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("  Это бефореич" );
    }

    @AfterEach
    void afterEach() {
        System.out.println("  Это Афтерич" );
    }

    @Test
    void firstTest() {
        System.out.println("  Это ТЕСТ" );
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("  Это ТЕСТ2" );
        Assertions.assertTrue(3>2);
    }
}

