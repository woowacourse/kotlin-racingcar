package domain

class Car(
    private val generator: NumberGenerator,
    private val name: String
) {
    private var distance = 0

    fun race() {
        val number = generator.generate()
        if (checkGo(number)) go()
    }

    private fun checkGo(number: Int): Boolean {
        if (number in RANGE_LOWER_INCLUSIVE..RANGE_UPPER_INCLUSIVE)
            return true
        return false
    }

    private fun go() {
        distance++
    }

    companion object {
        const val RANGE_LOWER_INCLUSIVE = 4
        const val RANGE_UPPER_INCLUSIVE = 9
    }
}
