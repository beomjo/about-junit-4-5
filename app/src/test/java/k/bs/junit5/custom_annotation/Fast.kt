package k.bs.junit5.custom_annotation

import org.junit.jupiter.api.Tag

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Tag("fast")
annotation class Fast