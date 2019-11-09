package k.bs.junit5.test_interface_default_test_method.example2

class StringTests : ComparableContract<String>, EqualsContract<String> {
    override fun createValue(): String {
        return "banana"
    }

    override fun createSmallerValue(): String {
        return "apple" // 'a' < 'b' in "banana"
    }

    override fun createNotEqualValue(): String {
        return "cherry"
    }
}