package k.bs.junit.test_rule.classrule

import k.bs.junit.test_rule.externalresource.Client
import org.junit.Assert
import org.junit.Test

class A {

    @Test
    fun testA() {
        println("testA")

        UsesExternalResourceTest.myServer
                .addUser(Client(1))

        Assert.assertEquals(1, UsesExternalResourceTest.myServer.activeUser.filter { it.userId == 1 }.size)
    }
}