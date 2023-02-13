package racingcar.model.car.move.step

sealed class MoveStep {
    abstract fun move(): Int
}

object ZeroStep : MoveStep() {
    private const val ZERO_STEP = 0

    override fun move(): Int = ZERO_STEP
}

object OneStep : MoveStep() {
    private const val ONE_STEP = 1

    override fun move(): Int = ONE_STEP
}
