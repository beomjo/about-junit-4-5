package k.bs.junit.test_order

import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.JVM) //JVM: 완료순서대로 리턴
class TestCaseOrderControl {

    @Test
    fun test2(){
     println("test2")
    }

    @Test
    fun test1(){
        println("test1")
    }


    @Test
    fun testA(){
        println("testA")
    }

    @Test
    fun test3(){
        println("test3")
    }

    @Test
    fun test4(){
        println("test4")
    }

    @Test
    fun test5(){
        println("test5")
    }
}