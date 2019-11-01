package k.bs.junit.test_rule.verifier

import org.hamcrest.CoreMatchers
import org.junit.Assert.assertThat
import org.junit.rules.Verifier
import org.junit.Rule
import org.junit.Test


class VerifierRuleTest {
    private var MAX_AGE = 25
    internal var peopleWithAgeGreaterThanMaxAge: MutableList<Person> = ArrayList()

    @get:Rule
    var verifier: Verifier = object : Verifier() {
        public override fun verify() {
            assertThat(peopleWithAgeGreaterThanMaxAge.size, CoreMatchers.equalTo(0))
        }
    }

    @Test
    fun personTest1() {
        val person = Person.Builder()
                .name("Frank")
                .age(20)
                .build()

        if (person.age > MAX_AGE) {
            peopleWithAgeGreaterThanMaxAge.add(person)
        }
    }

    @Test
    fun personTest2() {
        val person = Person.Builder()
                .name("Angela")
                .age(30)
                .build()

        if (person.age > MAX_AGE) {
            peopleWithAgeGreaterThanMaxAge.add(person)
        }
    }
}