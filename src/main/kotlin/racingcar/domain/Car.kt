package racingcar.domain

private const val MINIMUM_POWER_TO_MOVE = 4
private const val MAXIMUM_POWER_TO_MOVE = 9

class Car(name: String, position: Int = 0) {

    val name: String
    var position: Int
        private set

    init {
        val refined = name.trim()
        require(refined.length in 1..5) { "이름의 길이는 1 이상 5 이하입니다" }
        this.name = refined
        require(position >= 0) { "위치값은 0 이상이어야 합니다" }
        this.position = position
    }

    fun move(power: Int) {
        if (power in MINIMUM_POWER_TO_MOVE..MAXIMUM_POWER_TO_MOVE) {
            position++
        }
    }
}
