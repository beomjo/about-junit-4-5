package k.bs.junit5.assertions

import k.bs.junit5.sample.Person
import java.time.Duration.ofMillis
import java.time.Duration.ofMinutes
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertTimeout


internal class AssertionsDemo {

    private val calculator = Calculator()

    private val person = Person("Jane", "Doe")

    @Test
    fun standardAssertions() {
        assertEquals(2, calculator.add(1, 1))
        assertEquals(
            4, calculator.multiply(2, 2),
            "The optional failure message is now the last parameter"
        )
        assertTrue('a' < 'b') { "Assertion messages can be lazily evaluated -- to avoid constructing complex messages unnecessarily." }
    }

    @Test
    fun groupedAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
            { assertEquals("Jane", person.getFirstName()) },
            { assertEquals("Doe", person.getLastName()) }
        )
    }

    @Test
    fun dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
            {
                val firstName = person.getFirstName()
                assertNotNull(firstName)

                // Executed only if the previous assertion is valid.
                assertAll("first name",
                    { assertTrue(firstName.startsWith("J")) },
                    { assertTrue(firstName.endsWith("e")) }
                )
            },
            {
                // Grouped assertion, so processed independently
                // of results of first name assertions.
                val lastName = person.getLastName()
                assertNotNull(lastName)

                // Executed only if the previous assertion is valid.
                assertAll("last name",
                    { assertTrue(lastName.startsWith("D")) },
                    { assertTrue(lastName.endsWith("e")) }
                )
            }
        )
    }

    @Test
    fun exceptionTesting() {
        val exception = assertThrows(ArithmeticException::class.java) { calculator.divide(1, 0) }
        assertEquals("/ by zero", exception.message)
    }

    @Test
    fun timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2)) {
            // Perform task that takes less than 2 minutes.
        }
    }

    @Test
    fun timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.

        val actualResult = assertTimeout(ofMinutes(2)) { "a result" }
        assertEquals("a result", actualResult)
    }

    @Test
    fun timeoutNotExceededWithMethod() {
        // The following assertion invokes a method reference and returns an object.
        val actualGreeting: String = assertTimeout(ofMinutes(2)) { greeting() }
        assertEquals("Hello, World!", actualGreeting)
    }

    @Test
    fun timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10)) {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(5)
        }
    }

    @Test
    fun timeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(ofMillis(10)) {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100)
        }
    }

    private fun greeting(): String {
        return "Hello, World!"
    }
}