package k.bs.junit5.parameterized_test

import k.bs.junit5.parameterized_test.server.CsvToPerson
import k.bs.junit5.parameterized_test.server.MyArgumentsProvider
import k.bs.junit5.parameterized_test.server.PersonAggregator
import k.bs.junit5.parameterized_test.server.ToStringArgumentConverter
import k.bs.junit5.sample.Book
import k.bs.junit5.sample.Gender
import k.bs.junit5.sample.Person
import k.bs.junit5.test_interface_default_test_method.example1.TimingExtension
import k.bs.junit5.test_interface_default_test_method.example1.isPalindrome
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.aggregator.AggregateWith
import org.junit.jupiter.params.aggregator.ArgumentsAccessor
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.converter.JavaTimeConversionPattern
import org.junit.jupiter.params.provider.*
import java.time.LocalDate
import java.util.*
import java.util.concurrent.TimeUnit


class ParameterizedTests : MethodSourceTests() {

    @Nested
    @DisplayName("Test1")
    inner class Test1 {
        @ParameterizedTest
        @ValueSource(strings = ["racecar", "radar", "able was I ere I saw elba"])
        fun palindromes(candidate: String) {
            assertTrue(candidate.isPalindrome())
        }
    }

    @Nested
    @DisplayName("Test2")
    inner class NullAndEmptySourcesTests {
        @ParameterizedTest
        @NullSource
        @EmptySource
        @ValueSource(strings = [" ", "   ", "\t", "\n"])
        fun nullEmptyAndBlankStrings(text: String?) {
            assertTrue(text == null || text.trim { it <= ' ' }.isEmpty())
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = [" ", "   ", "\t", "\n"])
        fun nullEmptyAndBlankStrings2(text: String?) {
            assertTrue(text == null || text.trim { it <= ' ' }.isEmpty())
        }
    }


    @Nested
    @DisplayName("Test3")
    inner class EnumSourceTests {
        @ParameterizedTest
        @EnumSource(TimeUnit::class)
        fun testWithEnumSource(timeUnit: TimeUnit) {
            assertNotNull(timeUnit)
        }

        @ParameterizedTest
        @EnumSource(value = TimeUnit::class, names = ["DAYS", "HOURS"])
        fun testWithEnumSourceInclude(timeUnit: TimeUnit) {
            assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit))
        }

        @ParameterizedTest
        @EnumSource(
            value = TimeUnit::class,
            mode = EnumSource.Mode.EXCLUDE,
            names = ["DAYS", "HOURS"]
        )
        fun testWithEnumSourceExclude(timeUnit: TimeUnit) {
            assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit))
            assertTrue(timeUnit.name.length > 5)
        }

        @ParameterizedTest
        @EnumSource(
            value = TimeUnit::class,
            mode = EnumSource.Mode.MATCH_ALL,
            names = ["^(M|N).+SECONDS$"]
        )
        fun testWithEnumSourceRegex(timeUnit: TimeUnit) {
            val name = timeUnit.name
            assertTrue(name.startsWith("M") || name.startsWith("N"))
            assertTrue(name.endsWith("SECONDS"))
        }


    }

    @Nested
    @DisplayName("Test5")
    inner class CsvSourceTests {
        @ParameterizedTest
        @CsvSource(
            "apple,1",
            "banana,        2",
            "'lemon, lime', 0xF1"
        )
        fun testWithCsvSource(fruit: String, rank: Int) {
            assertNotNull(fruit)
            assertNotEquals(0, rank)
        }
    }

    @Nested
    @DisplayName("Test6")
    inner class ArgumentsSourceTests {
        @ParameterizedTest
        @ArgumentsSource(MyArgumentsProvider::class)
        fun testWithArgumentsSource(argument: String) {
            assertNotNull(argument)
        }

    }

    @Nested
    @DisplayName("Test7")
    inner class ArgumentsConversionTests {
        @ParameterizedTest
        @ValueSource(strings = ["SECONDS"])
        fun testWithImplicitArgumentConversion(argument: TimeUnit) {
            assertNotNull(argument.name)
        }

        @ParameterizedTest
        @ValueSource(strings = ["42 Cats"])
        fun testWithImplicitFallbackArgumentConversion(book: Book) {
            assertEquals("42 Cats", book.title)
        }

        @ParameterizedTest
        @EnumSource(TimeUnit::class)
        fun testWithExplicitArgumentConversion(@ConvertWith(ToStringArgumentConverter::class) argument: String) {
            assertNotNull(TimeUnit.valueOf(argument))
        }

        @ParameterizedTest
        @ValueSource(strings = ["01.01.2017", "31.12.2017"])
        fun testWithExplicitJavaTimeConverter(@JavaTimeConversionPattern("dd.MM.yyyy") argument: LocalDate) {
            assertEquals(2017, argument.year)
        }

    }

    @Nested
    @DisplayName("Test8")
    inner class ArgumentsAggregationTests {
        @ParameterizedTest
        @CsvSource(
            "Jane, Doe, F, 1990-05-20",
            "John, Doe, M, 1990-10-22"
        )
        fun testWithArgumentsAccessor(arguments: ArgumentsAccessor) {
            val person = Person(
                arguments.getString(0),
                arguments.getString(1),
                gender = arguments.get(2, Gender::class.java),
                birthDay = arguments.get(3, LocalDate::class.java)
            )

            if (person.getFirstName() == "Jane") {
                assertEquals(Gender.F, person.gender)
            } else {
                assertEquals(Gender.M, person.gender)
            }

            assertEquals("Doe", person.getLastName())
            assertEquals(1990, person.birthDay?.year)
        }

        @ParameterizedTest
        @CsvSource("Jane, Doe, F, 1990-05-20", "John, Doe, M, 1990-10-22")
        fun testWithArgumentsAggregator(@AggregateWith(PersonAggregator::class) person: Person) {
            // perform assertions against person
        }

        @ParameterizedTest
        @CsvSource("Jane, Doe, F, 1990-05-20", "John, Doe, M, 1990-10-22")
        fun testWithCustomAggregatorAnnotation(@CsvToPerson person: Person) {
            // perform assertions against person
        }
    }


    @Nested
    @DisplayName("Test9")
    inner class CustomDisplayNameTests {
        @DisplayName("Display name of container")
        @ParameterizedTest(name = "{index} ==> fruit=''{0}'', rank={1}")
        @CsvSource("apple, 1", "banana, 2", "'lemon, lime', 3")
        fun testWithCustomDisplayNames(fruit: String, rank: Int) {
        }
    }

    @Nested
    @DisplayName("Test10")
    inner class LifecycleAndInteroperabilityTests {
        @BeforeEach
        fun beforeEach(testInfo: TestInfo) {
            // ...
        }

        @ParameterizedTest
        @ValueSource(strings = ["apple", "banana"])
        fun testWithRegularParameterResolver(argument: String, testReporter: TestReporter) {
            testReporter.publishEntry("argument", argument)
        }

        @AfterEach
        fun afterEach(testInfo: TestInfo) {
            // ...
        }
    }
}