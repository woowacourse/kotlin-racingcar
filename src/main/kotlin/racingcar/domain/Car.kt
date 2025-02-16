package racingcar.domain

class Car(private val carName: String) {
    private var position: Int = 0

    fun getName(): String = carName

    fun getPosition(): Int = position

    fun moveOrStop(isMove: Boolean) {
        if (isMove) {
            position++
        }
    }
}
