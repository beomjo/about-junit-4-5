package k.bs.junit5.dynamictest

import org.junit.jupiter.api.DynamicNode
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.DynamicTest
import k.bs.junit5.assertions.Calculator
import k.bs.junit5.test_interface_default_test_method.example1.isPalindrome
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicContainer.dynamicContainer
import org.junit.jupiter.api.DynamicTest.dynamicTest
import java.util.*
import java.util.stream.IntStream
import java.util.stream.Stream


class DynamicTestsDemo {

    private val calculator = Calculator()

    // This will result in a JUnitException!
    @TestFactory
    fun dynamicTestsWithInvalidReturnType(): List<String> {
        return listOf("Hello")
    }

    @TestFactory
    fun dynamicTestsFromCollection(): Collection<DynamicTest> {
        return listOf(
            dynamicTest("1st dynamic test") { assertTrue("madam".isPalindrome()) },
            dynamicTest("2nd dynamic test") { assertEquals(4, calculator.multiply(2, 2)) }
        )
    }

    @TestFactory
    fun dynamicTestsFromIterable(): Iterable<DynamicTest> {
        return listOf(
            dynamicTest("3rd dynamic test") { assertTrue("madam".isPalindrome()) },
            dynamicTest("4th dynamic test") { assertEquals(4, calculator.multiply(2, 2)) }
        )
    }

    @TestFactory
    fun dynamicTestsFromIterator(): Iterator<DynamicTest> {
        return listOf(
            dynamicTest("5th dynamic test") { assertTrue("madam".isPalindrome()) },
            dynamicTest("6th dynamic test") { assertEquals(4, calculator.multiply(2, 2)) }
        ).iterator()
    }

    @TestFactory
    fun dynamicTestsFromArray(): Array<DynamicTest> {
        return arrayOf(
            dynamicTest("7th dynamic test") { assertTrue("madam".isPalindrome()) },
            dynamicTest("8th dynamic test") { assertEquals(4, calculator.multiply(2, 2)) })
    }

    @TestFactory
    fun dynamicTestsFromStream(): Stream<DynamicTest> {
        return listOf("racecar", "radar", "mom", "dad")
            .map { text -> dynamicTest(text) { assertTrue(text.isPalindrome()) } }
            .stream()
    }

    @TestFactory
    fun dynamicTestsFromIntStream(): Stream<DynamicTest> {
        // Generates tests for the first 10 even integers.
        return IntStream.iterate(0) { n -> n + 2 }.limit(10)
            .mapToObj { n -> dynamicTest("test$n") { assertTrue(n % 2 == 0) } }
    }

    @TestFactory
    fun generateRandomNumberOfTests(): Stream<DynamicTest> {

        // Generates random positive integers between 0 and 100 until
        // a number evenly divisible by 7 is encountered.
        val inputGenerator = object : Iterator<Int> {

            internal var random = Random()
            internal var current: Int = 0

            override fun hasNext(): Boolean {
                current = random.nextInt(100)
                return current % 7 != 0
            }

            override fun next(): Int {
                return current
            }
        }

        // Generates display names like: input:5, input:37, input:85, etc.
        val displayNameGenerator: (a: Int) -> String = { input -> "input:$input" }

        // Executes tests based on the current input value.
        val testExecutor: (a: Int) -> Unit = { input -> assertTrue(input % 7 != 0) }

        // Returns a stream of dynamic tests.
        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor)
    }

    @TestFactory
    fun dynamicTestsWithContainers(): Stream<DynamicNode> {
        return Stream.of("A", "B", "C")
            .map { input ->
                dynamicContainer(
                    "Container $input", Stream.of(
                        dynamicTest("not null") { assertNotNull(input) },
                        dynamicContainer("properties", Stream.of(
                            dynamicTest("length > 0") { assertTrue(input.isNotEmpty()) },
                            dynamicTest("not empty") { assertFalse(input.isEmpty()) }
                        ))
                    ))
            }
    }

    @TestFactory
    fun dynamicNodeSingleTest(): DynamicNode {
        return dynamicTest("'pop' is a palindrome") { assertTrue("pop".isPalindrome()) }
    }

    @TestFactory
    fun dynamicNodeSingleContainer(): DynamicNode {
        return dynamicContainer("palindromes",
            Stream.of("racecar", "radar", "mom", "dad")
                .map { text -> dynamicTest(text) { assertTrue(text.isPalindrome()) } })
    }
}