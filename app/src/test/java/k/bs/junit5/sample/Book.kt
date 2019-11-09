package k.bs.junit5.sample

class Book private constructor(val title: String) {
    companion object {
        @JvmStatic
        fun fromTitle(title: String): Book {
            return Book(title)
        }
    }
}