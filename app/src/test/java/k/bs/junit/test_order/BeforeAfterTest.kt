package k.bs.junit.test_order

import org.junit.*


class BeforeAfterTest {

    @Before
    @Throws(Exception::class)
    fun setUp() {
        println("@Before")
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        println("@After")
    }

    @Test
    @Throws(Exception::class)
    fun testCase1() {
        println("testCase1")
    }

    @Test
    @Throws(Exception::class)
    fun testCase2() {
        println("testCase2")
    }

    companion object {
        @BeforeClass
        @JvmStatic
        @Throws(Exception::class)
        fun setUpBeforeClass() {
            println("@BeforeClass")
        }

        @AfterClass
        @JvmStatic
        @Throws(Exception::class)
        fun tearDownAfterClass() {
            println("@AfterClass")
        }
    }
}