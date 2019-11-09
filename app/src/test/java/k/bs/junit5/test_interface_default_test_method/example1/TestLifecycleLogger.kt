package k.bs.junit5.test_interface_default_test_method.example1

import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import java.util.logging.Logger


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal interface TestLifecycleLogger {

    @BeforeAll
    fun beforeAllTests() {
        logger.info("Before all tests")
    }

    @AfterAll
    fun afterAllTests() {
        logger.info("After all tests")
    }

    @BeforeEach
    fun beforeEachTest(testInfo: TestInfo) {
        logger.info {
            String.format(
                "About to execute [%s]",
                testInfo.displayName
            )
        }
    }

    @AfterEach
    fun afterEachTest(testInfo: TestInfo) {
        logger.info {
            String.format(
                "Finished executing [%s]",
                testInfo.displayName
            )
        }
    }

    companion object {
        val logger = Logger.getLogger(TestLifecycleLogger::class.java.name)
    }

}