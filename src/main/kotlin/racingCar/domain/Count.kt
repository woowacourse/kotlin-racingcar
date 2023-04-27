package racingCar.domain

data class Count(private var count: Int) {
    init {
        require(count > MIN) { UNDER_MIN_ERROR_MESSAGE }
    }

    fun deduct() {
        count = count.dec()
    }

    fun isOpportunity(): Boolean {
        return count > MIN
    }

    companion object {
        private const val MIN: Int = 0
        private const val UNDER_MIN_ERROR_MESSAGE: String = "숫자를 입력하세요"
    }
}
