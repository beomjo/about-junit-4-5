package k.bs.junit5.test_interface_default_test_method.example1


fun String.isPalindrome(): Boolean {
    val length = this.length
    for (i in 0 until length / 2) {
        if (this[i] != this[length - (i + 1)]) {
            return false
        }
    }
    return true
}

