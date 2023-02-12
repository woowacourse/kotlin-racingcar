package domain

class RaceTime(private var time: Int) {

    init {
        validateRange()
    }

    private fun validateRange() {
        require(time in 1..10) { ERROR_NOT_IN_RANGE }
    }

    fun reduceTime(): Boolean {
        if (time <= 0) {
            return false
        }
        time--
        return true
    }

    companion object {
        const val ERROR_NOT_IN_RANGE = "시도 횟수는 1이상 10 이하여야 합니다."
    }
}
