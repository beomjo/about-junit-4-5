package k.bs.junit5.conditional_test_excution.operate_system

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Test
@EnabledOnOs(OS.MAC)
internal annotation class TestOnMac