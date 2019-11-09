package k.bs.junit5.test_interface_default_test_method.example2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

interface EqualsContract<T> : Testable<T> {

    fun createNotEqualValue(): T

    @Test
    fun valueEqualsItself() {
        val value = createValue()
        assertEquals(value, value)
    }

    @Test
    fun valueDoesNotEqualNull() {
        val value = createValue()
        assertFalse(value == null)
    }

    @Test
    fun valueDoesNotEqualDifferentValue() {
        val value = createValue()
        val differentValue = createNotEqualValue()
        assertNotEquals(value, differentValue)
        assertNotEquals(differentValue, value)
    }

}