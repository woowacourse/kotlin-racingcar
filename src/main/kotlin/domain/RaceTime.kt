package domain

class RaceTime(private var time: Int) {

    init {
        validateRange()
    }

    fun reduceTime(): Boolean {
        if (time <= 0) {
            return false
        }
        time--
        return true
    }

    private fun validateRange() {
        require(time in 1..10) { ERROR_NOT_IN_RANGE }
    }

    companion object {
        const val ERROR_NOT_IN_RANGE = "시도 횟수는 1이상 10 이하여야 합니다."
    }
}