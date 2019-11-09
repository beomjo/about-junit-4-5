package k.bs.junit5.assertions.kotlin

class FibonacciCalculator {
    fun fib(num:Int): Int {
        var first = 1
        var second = 1
        return when (num) {
            1 -> first
            2 -> second
            else -> {
                var current = first + second
                for (num in 3..num) {
                    current = first + second
                    first = second
                    second = current
                }
                current
            }
        }
    }
}