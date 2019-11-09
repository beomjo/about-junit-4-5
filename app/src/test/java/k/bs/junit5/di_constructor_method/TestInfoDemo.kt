package k.bs.junit5.di_constructor_method

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*


@DisplayName("TestInfo Demo")
internal class TestInfoDemo(testInfo: TestInfo) {

    init {
        println("init call")
        assertEquals("TestInfo Demo", testInfo.displayName)
    }

    @BeforeEach
    fun init(testInfo: TestInfo) {
        val displayName = testInfo.displayName
        assertTrue(displayName == "TEST 1" || displayName == "test2()")
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    fun test1(testInfo: TestInfo) {
        assertEquals("TEST 1", testInfo.displayName)
        assertTrue(testInfo.tags.contains("my-tag"))
    }

    @Test
    fun test2() {
    }

}
