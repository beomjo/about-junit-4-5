package k.bs.junit.test_rule.externalresource

import org.junit.Assert
import org.junit.rules.ExternalResource
import org.junit.Rule
import org.junit.Test


class UsesExternalResourceTest {
    internal var myServer = Server()

    @get:Rule
    val resource: ExternalResource = object : ExternalResource() {
        @Throws(Throwable::class)
        override fun before() {
            myServer.connect()
        }

        override fun after() {
            myServer.disconnect()
        }
    }

    @Test
    fun testFoo() {
        val user = Client(1)

        user.run(myServer)

        Assert.assertEquals(1, myServer.activeUser.size)
    }
}