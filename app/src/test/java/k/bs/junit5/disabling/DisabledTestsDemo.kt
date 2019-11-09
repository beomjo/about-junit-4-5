package k.bs.junit5.disabling

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test


class DisabledTestsDemo {

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    fun testWillBeSkipped() {
    }

    @Test
    fun testWillBeExecuted() {
    }

}