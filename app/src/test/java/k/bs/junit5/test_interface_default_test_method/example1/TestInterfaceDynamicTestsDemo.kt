package k.bs.junit5.test_interface_default_test_method.example1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

interface TestInterfaceDynamicTestsDemo {

    @TestFactory
    fun dynamicTestsForPalindromes(): List<DynamicTest> {
        return listOf("racecar", "radar", "mom", "dad")
            .map { t -> dynamicTest(t) { Assertions.assertTrue(t.isPalindrome()) } }
    }
}

