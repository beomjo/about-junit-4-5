package k.bs.junit5.test_interface_default_test_method.example2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

interface ComparableContract<T : Comparable<T>> : Testable<T> {

    fun createSmallerValue(): T

    @Test
    fun returnsZeroWhenComparedToItself() {
        val value = createValue()
        assertEquals(0, value.compareTo(value))
    }

    @Test
    fun returnsPositiveNumberWhenComparedToSmallerValue() {
        val value = createValue()
        val smallerValue = createSmallerValue()
        assertTrue(value > smallerValue)
    }

    @Test
    fun returnsNegativeNumberWhenComparedToLargerValue() {
        val value = createValue()
        val smallerValue = createSmallerValue()
        assertTrue(smallerValue < value)
    }
}