package racingcar.domain

private const val MIN_POWER = 4
private const val INITIAL_POSITION = 0

class Car(val name: String, var position: Position = Position(INITIAL_POSITION)) {
    fun go(power: Int) {
        when {
            power >= MIN_POWER -> position = position.plus()
        }
    }
}