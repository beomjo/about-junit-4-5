package k.bs.junit.test_rule.customrule

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class LoggingRule(private val name: String) : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                    println("start: $name")
                    base.evaluate()
                    println("end: $name")
            }
        }
    }
}