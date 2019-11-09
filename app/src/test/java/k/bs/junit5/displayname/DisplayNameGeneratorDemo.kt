package k.bs.junit5.displayname

import org.junit.jupiter.api.*
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.params.ParameterizedTest
import java.lang.reflect.Method


class DisplayNameGeneratorDemo {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
    inner class A_year_is_not_supported {

        @Test
        fun if_it_is_zero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = [-1, -4])
        fun if_it_is_negative(year: Int) {
        }
    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences::class)
    inner class A_year_is_a_leap_year {

        @Test
        fun if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = [2016, 2020, 2048])
        fun if_it_is_one_of_the_following_years(year: Int) {
        }
    }

    class IndicativeSentences : DisplayNameGenerator.ReplaceUnderscores() {
        override fun generateDisplayNameForNestedClass(nestedClass: Class<*>): String {
            return super.generateDisplayNameForNestedClass(nestedClass) + "..."
        }

        override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String {
            val name = testClass.simpleName + ' ' + testMethod.name
            return name.replace('_', ' ') + '.'
        }
    }
}