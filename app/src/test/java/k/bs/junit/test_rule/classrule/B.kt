package k.bs.junit.test_rule.classrule

import k.bs.junit.test_rule.externalresource.Client
import org.junit.Assert
import org.junit.Test

class B {
    @Test
    fun testB(){
        println("testB")

        UsesExternalResourceTest.myServer
                .addUser(Client(2))

        Assert.assertEquals(1, UsesExternalResourceTest.myServer.activeUser.filter { it.userId == 2 }.size)
    }
}