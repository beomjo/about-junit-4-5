package k.bs.junit5.sample

import java.time.LocalDate

class Person(vararg val name: String, val gender: Gender? = null, val birthDay: LocalDate? = null) {

    fun getFirstName() = name.first()
    fun getLastName() = name.last()
}