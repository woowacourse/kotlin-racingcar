package racingcar.model.car.move.condition

class FakeCarRandomMoveCondition {
    class FakeForSuccess : CarMoveCondition {
        override operator fun invoke(): Int = SUCCESS_NUMBER
    }

    class FakeForFailed : CarMoveCondition {
        override operator fun invoke(): Int = FAIL_NUMBER
    }

    companion object {
        private const val FAIL_NUMBER = 0
        private const val SUCCESS_NUMBER = 9
    }
}
