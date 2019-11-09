package k.bs.junit5.parameterized_test.server

import org.junit.jupiter.params.aggregator.AggregateWith


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
@AggregateWith(PersonAggregator::class)
annotation class CsvToPerson