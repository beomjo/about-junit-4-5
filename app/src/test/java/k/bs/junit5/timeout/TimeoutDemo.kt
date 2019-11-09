package k.bs.junit5.timeout

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit


class TimeoutDemo {

    @BeforeEach
    @Timeout(5)
    fun setUp() {
        // fails if execution time exceeds 5 seconds
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    fun failsIfExecutionTimeExceeds100Milliseconds() {
        // fails if execution time exceeds 100 milliseconds
    }

    @Test
    @Timeout(5) // Poll at most 5 seconds
    @Throws(InterruptedException::class)
    fun pollUntil() {
        while (asynchronousResultNotAvailable()) {
            Thread.sleep(250) // custom poll interval
        }
        // Obtain the asynchronous result and perform assertions
    }

    private fun asynchronousResultNotAvailable() = true
}