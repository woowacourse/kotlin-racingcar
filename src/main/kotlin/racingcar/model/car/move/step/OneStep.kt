package racingcar.model.car.move.step

class OneStep : MoveStep {
    override fun move(): Int = ONE_STEP

    companion object {
        private const val ONE_STEP = 1
    }
}
