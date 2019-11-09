package k.bs.junit5.conditional_test_excution.script_based

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIf
import org.junit.jupiter.api.condition.DisabledIf
import java.time.LocalDate


class ScriptBasedTests {
    @Test // Static JavaScript expression.
    @EnabledIf("2 * 3 == 6")
    fun willBeExecuted() {
        // ...
    }

    @RepeatedTest(10) // Dynamic JavaScript expression.
    @DisabledIf("Math.random() < 0.314159")
    fun mightNotBeExecuted() {
        // ...
    }

    @Test // Regular expression testing bound system property.
    @DisabledIf("/32/.test(systemProperty.get('os.arch'))")
    fun disabledOn32BitArchitectures() {
        assertFalse(System.getProperty("os.arch")!!.contains("32"))
    }

    @Test
    @EnabledIf("'CI' == systemEnvironment.get('ENV')")
    fun onlyOnCiServer() {
        assertTrue("CI" == System.getenv("ENV"))
    }

    @Test // Multi-line script, custom engine name and custom reason.
    @EnabledIf(
        value = ["load('nashorn:mozilla_compat.js')", "importPackage(java.time)", "", "var today = LocalDate.now()", "var tomorrow = today.plusDays(1)", "tomorrow.isAfter(today)"],
        engine = "nashorn",
        reason = "Self-fulfilling: {result}"
    )

    fun theDayAfterTomorrow() {
        val today = LocalDate.now()
        val tomorrow = today.plusDays(1)
        assertTrue(tomorrow.isAfter(today))
    }
}