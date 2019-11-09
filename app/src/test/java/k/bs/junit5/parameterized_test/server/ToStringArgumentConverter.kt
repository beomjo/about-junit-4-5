package k.bs.junit5.parameterized_test.server

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.converter.SimpleArgumentConverter


class ToStringArgumentConverter : SimpleArgumentConverter() {

    override fun convert(source: Any, targetType: Class<*>): Any {
        assertEquals(String::class.java, targetType, "Can only convert to String")
        return source.toString()
    }
}