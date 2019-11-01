package k.bs.junit.test_rule.testname

import org.junit.Assert.assertEquals
import org.junit.rules.TestName
import org.junit.Rule
import org.junit.Test


class NameRuleTest {
    @get:Rule
    val name = TestName()

    @Test
    fun testA() {
        assertEquals("testA", name.methodName)
    }

    @Test
    fun testB() {
        assertEquals("testB", name.methodName)
    }
}