package k.bs.junit5.custom_annotation

import org.junit.Test

class CustomAnnotationTest {

    @Fast
    @Test
    fun myFastTest() {
        //..
    }

    @FastTest
    fun myFastTest2() {

    }
}