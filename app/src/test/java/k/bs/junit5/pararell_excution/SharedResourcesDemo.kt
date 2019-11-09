package k.bs.junit5.pararell_excution

import org.junit.jupiter.api.parallel.Resources.SYSTEM_PROPERTIES
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import org.junit.jupiter.api.parallel.ResourceAccessMode
import org.junit.jupiter.api.parallel.ResourceLock
import java.util.*


@Execution(ExecutionMode.CONCURRENT)
class SharedResourcesDemo {

    private var backup: Properties? = null

    @BeforeEach
    fun backup() {
        backup = Properties()
        backup!!.putAll(System.getProperties())
    }

    @AfterEach
    fun restore() {
        System.setProperties(backup)
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ)
    fun customPropertyIsNotSetByDefault() {
        assertNull(System.getProperty("my.prop"))
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    fun canSetCustomPropertyToApple() {
        System.setProperty("my.prop", "apple")
        assertEquals("apple", System.getProperty("my.prop"))
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    fun canSetCustomPropertyToBanana() {
        System.setProperty("my.prop", "banana")
        assertEquals("banana", System.getProperty("my.prop"))
    }
}