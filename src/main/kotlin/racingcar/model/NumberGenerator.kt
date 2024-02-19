package racingcar.model

class NumberGenerator(
    private val pickingStrategy: PickingStrategy
) {
    fun getNumber(): Int = pickingStrategy.pickNumber()
}
