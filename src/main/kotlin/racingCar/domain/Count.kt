package racingCar.domain

data class Count(private var count: Int) {
    init {
        require(count > 0) { "숫자를 입력하세요" }
    }

    fun deduct() {
        count = count.dec()
    }

    fun isOpportunity(): Boolean {
        return count > 0
    }
}
