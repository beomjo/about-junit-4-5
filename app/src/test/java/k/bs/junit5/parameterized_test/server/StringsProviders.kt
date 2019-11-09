package k.bs.junit5.parameterized_test.server

import java.util.stream.Stream

object StringsProviders {

    @JvmStatic
    fun tinyStrings(): Stream<String> {
        return listOf(".", "oo", "OOO").stream()
    }
}