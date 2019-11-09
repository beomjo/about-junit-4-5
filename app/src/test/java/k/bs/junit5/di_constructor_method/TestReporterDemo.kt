package k.bs.junit5.di_constructor_method

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestReporter


class TestReporterDemo {

    @Test
    fun reportSingleValue(testReporter: TestReporter) {
        testReporter.publishEntry("a status message")
    }

    @Test
    fun reportKeyValuePair(testReporter: TestReporter) {
        testReporter.publishEntry("a key", "a value")
    }

    @Test
    fun reportMultipleKeyValuePairs(testReporter: TestReporter) {
        val values = HashMap<String, String>()
        values.put("user name", "dk38")
        values.put("award year", "1974")

        testReporter.publishEntry(values)
    }

}