package k.bs.junit.test_rule.timeout

import org.junit.rules.Timeout
import org.junit.rules.TestRule
import org.junit.Rule
import org.junit.Test


class HasGlobalTimeout {

    @get:Rule
    val globalTimeout: TestRule = Timeout.millis(20)

    @Test
    fun testInfiniteLoop1() {
        log += "ran1"

        while (true) {
        }

    }

    @Test
    fun testInfiniteLoop2() {
        log += "ran2"
        while (true) {
        }
    }

    companion object {
        var log: String = ""
    }
}