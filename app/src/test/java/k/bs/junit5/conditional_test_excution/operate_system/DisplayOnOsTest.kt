package k.bs.junit5.conditional_test_excution.operate_system

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS


class DisplayOnOsTest {

    @Test
    @EnabledOnOs(OS.MAC)
    fun onlyOnMacOs() {
        //..
    }

    @TestOnMac
    fun testOnMac() {
        //.
    }

    @Test
    @EnabledOnOs(OS.LINUX, OS.MAC)
    fun onLinuxOrMac() {
        //.
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    fun notOnWindows() {
        //.
    }

    @Test
    @DisabledOnOs(OS.MAC)
    fun notOnMac(){
        //.
    }
}