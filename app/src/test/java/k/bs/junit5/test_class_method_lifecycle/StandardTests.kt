package k.bs.junit5.test_class_method_lifecycle

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assumptions.assumeTrue


class StandardTests {

    @BeforeEach
    fun init() {
    }

    @Test
    fun succeedingTest() {
    }

    @Test
    fun failingTest() {
        fail("a failing test")
    }

    @Test
    @Disabled("for demonstration purposes")
    fun skippedTest() {
        // not executed
    }

    @Test
    fun abortedTest() {
        assumeTrue("abc".contains("Z"))
        fail("test should have been aborted")
    }

    @AfterEach
    fun tearDown() {
    }

    companion object {

        @BeforeAll
        fun initAll() {
        }

        @AfterAll
        fun tearDownAll() {
        }
    }
}