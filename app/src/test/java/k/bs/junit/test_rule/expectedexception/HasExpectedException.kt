package k.bs.junit.test_rule.expectedexception

import org.hamcrest.CoreMatchers.startsWith
import org.junit.rules.ExpectedException
import org.junit.Rule
import org.junit.Test


class HasExpectedException {
    @get:Rule
    val thrown = ExpectedException.none()

    @Test
    fun throwsNothing() {

    }

    @Test
    fun throwsNullPointerException() {
        thrown.expect(NullPointerException::class.java)
        throw NullPointerException()
    }

    @Test
    fun throwsNullPointerExceptionWithMessage() {
        thrown.expect(NullPointerException::class.java)
        thrown.expectMessage("happened?")
        thrown.expectMessage(startsWith("What"))
        throw NullPointerException("What happened?")
    }
}