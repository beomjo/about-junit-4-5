package k.bs.junit5.tagging_filtering

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Tags(Tag("fast"), Tag("model"))
class TaggingDemo {

    @Test
    @Tag("taxes")
    fun testingTaxCalculation() {
    }

}