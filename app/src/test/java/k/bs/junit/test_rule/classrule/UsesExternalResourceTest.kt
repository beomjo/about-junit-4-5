package k.bs.junit.test_rule.classrule

import k.bs.junit.test_rule.externalresource.Server
import org.junit.rules.ExternalResource
import org.junit.ClassRule
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(A::class, B::class)
class UsesExternalResourceTest {

    companion object {
        val myServer = Server()

        @get:ClassRule
        @JvmStatic
        val resource: ExternalResource = object : ExternalResource() {
            @Throws(Throwable::class)
            override fun before() {
                myServer.connect()
            }

            override fun after() {
                myServer.disconnect()
            }
        }
    }
}