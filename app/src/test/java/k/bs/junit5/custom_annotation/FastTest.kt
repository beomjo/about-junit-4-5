package k.bs.junit5.custom_annotation

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Tag("fast")
@Test
annotation class FastTest