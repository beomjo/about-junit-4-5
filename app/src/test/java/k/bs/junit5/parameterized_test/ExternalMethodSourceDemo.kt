package k.bs.junit5.parameterized_test

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ExternalMethodSourceDemo {
    @ParameterizedTest
    @MethodSource("k.bs.junit5.parameterized_test.server.StringsProviders#tinyStrings")
    fun testWithExternalMethodSource(tinyString: String) {
        // test with tiny string
    }
}