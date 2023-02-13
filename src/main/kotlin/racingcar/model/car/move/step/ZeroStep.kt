package racingcar.model.car.move.step

class ZeroStep : MoveStep {
    override fun move(): Int = ZERO_STEP

    companion object {
        private const val ZERO_STEP = 0
    }
}
