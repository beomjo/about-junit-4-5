package k.bs.junit5.test_execution_order

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder


@TestMethodOrder(OrderAnnotation::class)
class OrderedTestsDemo {

    @Test
    @Order(1)
    fun nullValues() {
        // perform assertions against null values
    }

    @Test
    @Order(2)
    fun emptyValues() {
        // perform assertions against empty values
    }

    @Test
    @Order(3)
    fun validValues() {
        // perform assertions against valid values
    }
}