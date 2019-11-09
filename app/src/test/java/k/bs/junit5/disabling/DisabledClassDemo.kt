package k.bs.junit5.disabling

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test


@Disabled("Disabled until bug #99 has been fixed")
class DisabledClassDemo {

    @Test
    fun testWillBeSkipped() {
    }
}