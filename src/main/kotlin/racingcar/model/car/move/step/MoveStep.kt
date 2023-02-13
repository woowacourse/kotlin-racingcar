package racingcar.model.car.move.step

sealed class MoveStep {
    abstract fun move(): Int
}

object ZeroStep : MoveStep() {
    override fun move(): Int = 0
}

object OneStep : MoveStep() {
    override fun move(): Int = 1
}
