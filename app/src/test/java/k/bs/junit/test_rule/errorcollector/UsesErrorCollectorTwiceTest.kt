package k.bs.junit.test_rule.errorcollector

import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ErrorCollector


class UsesErrorCollectorTwiceTest {
    @get:Rule
    val collector = ErrorCollector()

    @Test
    fun example() {
        collector.addError(Throwable("first thing went wrong"))
        collector.addError(Throwable("second thing went wrong"))

        collector.checkThat("a", equalTo("b"))
        collector.checkThat(1, equalTo(2))
        println("Test continues even if an error occurs")
    }
}