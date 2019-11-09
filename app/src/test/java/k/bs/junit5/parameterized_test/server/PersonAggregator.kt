package k.bs.junit5.parameterized_test.server

import k.bs.junit5.sample.Person
import k.bs.junit5.sample.Gender
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.params.aggregator.ArgumentsAccessor
import org.junit.jupiter.params.aggregator.ArgumentsAggregator
import java.time.LocalDate


class PersonAggregator : ArgumentsAggregator {
    override fun aggregateArguments(
        arguments: ArgumentsAccessor,
        context: ParameterContext
    ): Person {
        return Person(
            arguments.getString(0),
            arguments.getString(1),
            gender = arguments.get(2, Gender::class.java),
            birthDay = arguments.get(3, LocalDate::class.java)
        )
    }
}