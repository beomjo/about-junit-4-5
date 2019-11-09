package k.bs.junit5.test_interface_default_test_method.example1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestInterfaceDemo : TestLifecycleLogger,
    TimeExecutionLogger,
    TestInterfaceDynamicTestsDemo {

    @Test
    fun isEqualValue() {
        Assertions.assertEquals(1, "a".length, "is always equal")
    }

}