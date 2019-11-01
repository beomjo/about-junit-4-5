package k.bs.junit.test_rule.testwatcher

import org.junit.AfterClass
import org.junit.Assert.fail
import org.junit.AssumptionViolatedException
import org.junit.rules.TestWatcher
import org.junit.rules.TestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.Description
import org.junit.runners.model.Statement


class WatchermanTest {

    @get:Rule
    val watchman: TestRule = object : TestWatcher() {
        fun applying(base: Statement, description: Description): Statement {
            return super.apply(base, description)
        }

        override fun succeeded(description: Description) {
            watchedLog += description.displayName + " " + "success!\n"
        }

        override fun failed(e: Throwable, description: Description) {
            watchedLog += description.displayName + " " + e.javaClass.simpleName + "\n"
        }

        override fun skipped(e: AssumptionViolatedException, description: Description) {
            watchedLog += description.displayName + " " + e.cause + "\n"
        }

        override fun starting(description: Description) {
            super.starting(description)
        }

        override fun finished(description: Description) {
            super.finished(description)
        }
    }

    @Test
    fun fails() {
        fail()
    }

    @Test
    fun test_success() {
    }

    companion object {
        private var watchedLog = ""

        @AfterClass
        @JvmStatic
        fun teardown() {
            println(watchedLog)
        }
    }
}