package k.bs.junit.test_rule.rulechain

import k.bs.junit.test_rule.customrule.LoggingRule
import org.junit.Assert.assertTrue
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.Rule
import org.junit.Test


class UseRuleChainTest {
    @get:Rule
    val chain: TestRule = RuleChain
            .outerRule(LoggingRule("outer rule"))
            .around(LoggingRule("middle rule"))
            .around(LoggingRule("inner rule"))

    @Test
    fun example() {
        assertTrue(true)
    }
}