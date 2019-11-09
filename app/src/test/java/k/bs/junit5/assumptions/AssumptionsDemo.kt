package k.bs.junit5.assumptions

import k.bs.junit5.assertions.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.junit.jupiter.api.Assumptions.assumingThat
import org.junit.jupiter.api.Test


class AssumptionsDemo {

    private val calculator = Calculator()

    @Test
    fun testOnlyOnCiServer() {
        assumeTrue("CI" == System.getenv("ENV"))
        // remainder of test
    }

    @Test
    fun testOnlyOnDeveloperWorkstation() {
        assumeTrue(
            "DEV" == System.getenv("ENV")
        ) { "Aborting test: not on developer workstation" }
        // remainder of test
    }

    @Test
    fun testInAllEnvironments() {
        assumingThat(
            "CI" == System.getenv("ENV")
        ) {
            // perform these assertions only on the CI server
            assertEquals(2, calculator.divide(4, 2))
        }

        // perform these assertions in all environments
        assertEquals(42, calculator.multiply(6, 7))
    }
}