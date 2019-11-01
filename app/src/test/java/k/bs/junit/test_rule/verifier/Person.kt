package k.bs.junit.test_rule.verifier

class Person(val name: String, val age: Int) {

    class Builder {
        var name: String = ""
        var age: Int = 0

        fun name(name: String): Builder {
            this.name = name
            return this
        }

        fun age(age: Int): Builder {
            this.age = age
            return this
        }

        fun build() = Person(name, age)
    }
}
