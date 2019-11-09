package k.bs.junit5.nested_test

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.util.*


@DisplayName("A stack")
class TestingAStackDemo {

    var stack: Stack<Any>? = null

    @Test
    @DisplayName("is instantiated with new Stack()")
    fun isInstantiatedWithNew() {
        stack = Stack()
    }

    @Nested
    @DisplayName("when new")
    internal inner class WhenNew {

        @BeforeEach
        fun createNewStack() {
            stack = Stack()
        }

        @Test
        @DisplayName("is empty")
        fun isEmpty() {
            assertTrue(stack.isNullOrEmpty())
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        fun throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException::class.java) {
                stack?.pop()
            }
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        fun throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException::class.java) {
                stack?.peek()
            }
        }

        @Nested
        @DisplayName("after pushing an element")
        inner class AfterPushing {

            var anElement = "an element"

            @BeforeEach
            fun pushAnElement() {
                stack?.push(anElement)
            }

            @Test
            @DisplayName("it is no longer empty")
            fun isNotEmpty() {
                assertFalse(stack.isNullOrEmpty())
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            fun returnElementWhenPopped() {
                assertEquals(anElement, stack?.pop())
                assertTrue(stack.isNullOrEmpty())
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            fun returnElementWhenPeeked() {
                assertEquals(anElement, stack?.peek())
                assertFalse(stack.isNullOrEmpty())
            }
        }
    }
}