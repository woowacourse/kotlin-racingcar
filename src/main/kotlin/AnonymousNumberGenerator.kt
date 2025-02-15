class AnonymousNumberGenerator : AnonymousNumberStrategy {
    override fun getNumber(excludeNumbers: Set<Int>): Int {
        val randomNumbers = (TRY_NUMBER_TO..TRY_NUMBER_UNTIL).subtract(excludeNumbers)
        return randomNumbers.random()
    }

    companion object {
        const val TRY_NUMBER_UNTIL = 1000
        const val TRY_NUMBER_TO = 1
    }
}
