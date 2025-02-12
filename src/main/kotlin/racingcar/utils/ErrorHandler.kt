package racingcar.utils

object ErrorHandler {
    fun String.validCarName(): String {
        val carNames = this.split(",")
        if (carNames.duplicateCarNames()
            || carNames.emptyCarNames()
            || carNames.carNameLength()
        ) throw IllegalArgumentException("[ERROR] 자동차 이름을 다시 입력해주세요.")
        return this
    }

    private fun List<String>.duplicateCarNames(): Boolean {
        return this.size != this.toSet().size
    }

    private fun List<String>.emptyCarNames(): Boolean {
        this.forEach { carName ->
            return carName.isBlank()
        }
        return false
    }

    private fun List<String>.carNameLength(): Boolean {
        this.forEach { carName ->
            return carName.length > 5
        }
        return false
    }

    fun String.validTryCount(): String {

        if (this.toIntTryCount() || this.emptyTryCount()) throw IllegalArgumentException("[ERROR] 시도횟수를 다시 입력해주세요.")
        return this
    }

    private fun String.toIntTryCount(): Boolean {
        return this.toIntOrNull() == null
    }

    private fun String.emptyTryCount(): Boolean {
        return this.isBlank()
    }

    fun Int.validRandomNumber(): Int {
        if (this !in 0..9) throw IllegalArgumentException("[ERROR] 0-9사이 숫자가 아닙니다.")
        return this
    }
}
