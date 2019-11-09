package k.bs.junit5.parameterized_test

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@Nested
open class MethodSourceTests {

    @ParameterizedTest
    @MethodSource("stringProvider")
    @DisplayName("Test4 - testWithExplicitLocalMethodSource")
    fun testWithExplicitLocalMethodSource(argument: String) {
        Assertions.assertNotNull(argument)
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Test4 - testWithDefaultLocalMethodSource")
    fun testWithDefaultLocalMethodSource(argument: String) {
        Assertions.assertNotNull(argument)
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    @DisplayName("Test4 - testWithMultiArgMethodSource")
    fun testWithMultiArgMethodSource(str: String, num: Int, list: List<String>) {
        Assertions.assertEquals(5, str.length)
        Assertions.assertTrue(num in 1..2)
        Assertions.assertEquals(2, list.size)
    }

    companion object {
        @JvmStatic
        fun stringProvider(): Stream<String> = listOf("apple", "banana").stream()

        @JvmStatic
        fun testWithDefaultLocalMethodSource(): Stream<String> =
            listOf("apple", "banana").stream()

        @JvmStatic
        fun stringIntAndListProvider(): Stream<Arguments> {
            return listOf<Arguments>(
                Arguments.of("apple", 1, listOf("a", "b")),
                Arguments.of("lemon", 2, listOf("x", "y"))
            ).stream()
        }
    }
}