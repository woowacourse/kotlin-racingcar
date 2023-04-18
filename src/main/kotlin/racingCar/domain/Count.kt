package racingCar.domain

data class Count(private var count: Int) {
    init {
        if (this.count <= 0) {
            throw IllegalArgumentException("숫자를 입력하세요")
        }
    }

    fun deduct() {
        this.count = this.count.dec()
    }

    fun isOpportunity(): Boolean {
        return this.count > 0
    }
}
