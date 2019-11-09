package k.bs.junit5.di_constructor_method

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.util.logging.Logger

class RepeatedTestsDemo {

    private val logger = Logger.getLogger(this::class.java.canonicalName)

    @BeforeEach
    fun beforeEach(testInfo: TestInfo, repetitionInfo: RepetitionInfo) {
        val currentRepetition = repetitionInfo.currentRepetition
        val totalRepetitions = repetitionInfo.totalRepetitions
        val methodName = testInfo.testMethod.get().name
        logger.info(
            String.format(
                "About to execute repetition %d of %d for %s", //
                currentRepetition, totalRepetitions, methodName
            )
        );
    }

    @RepeatedTest(10)
    fun repeatedTest() {
        // ...
    }

    @RepeatedTest(5)
    fun repeatedTestWithRepetitionInfo(repetitionInfo: RepetitionInfo) {
        assertEquals(5, repetitionInfo.totalRepetitions);
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    fun customDisplayName(testInfo: TestInfo) {
        assertEquals("Repeat! 1/1", testInfo.displayName);
    }

    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    fun customDisplayNameWithLongPattern(testInfo: TestInfo) {
        assertEquals("Details... :: repetition 1 of 1", testInfo.displayName);
    }

    @RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
    fun repeatedTestInGerman() {
        // ...
    }

}
