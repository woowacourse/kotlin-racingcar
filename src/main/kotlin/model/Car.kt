package model

class Car(private val name: String) {
    private var step: Int = DEFAULT_STEP

    init {
        require(name.trim().length in MIN_VALUE..MAX_VALUE) { CAR_NAME_LENGTH_MESSAGE }
    }

    fun tryForward(randomValue: Int) {
        if (randomValue >= FORWARD_VALUE) step++
    }

    fun getName(): String = this.name

    fun getStep(): String = "-".repeat(this.step)

    private companion object {
        const val DEFAULT_STEP: Int = 0
        const val FORWARD_VALUE: Int = 4
        const val MAX_VALUE: Int = 5
        const val MIN_VALUE: Int = 1
        const val CAR_NAME_LENGTH_MESSAGE = "자동차 이름의 길이는 최소 $MIN_VALUE 최대 ${MAX_VALUE}글자여야 합니다."
    }
}
