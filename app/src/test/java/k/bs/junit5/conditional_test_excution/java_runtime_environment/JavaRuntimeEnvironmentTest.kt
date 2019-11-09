package k.bs.junit5.conditional_test_excution.java_runtime_environment

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledOnJre
import org.junit.jupiter.api.condition.EnabledOnJre
import org.junit.jupiter.api.condition.JRE


class JavaRuntimeEnvironmentTest {
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    fun onlyOnJava8() {
        // ...
    }

    @Test
    @EnabledOnJre(JRE.JAVA_9, JRE.JAVA_10)
    fun onJava9Or10() {
        // ...
    }

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    fun notOnJava9() {
        // ...
    }
}