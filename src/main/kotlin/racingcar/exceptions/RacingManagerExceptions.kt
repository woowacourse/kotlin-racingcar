package racingcar.exceptions

import racingcar.misc.Values
import racingcar.model.Car

class RacingManagerExceptions {
    companion object {
        fun validateStep(number: Int) {
            require(number in Values.MIN_RANDOM_NUMBER..Values.MAX_RANDOM_NUMBER) { "생성된 임의 숫자는 0에서 9사이어야 합니다." }
        }

        fun validateCarCount(cars: List<Car>) {
            require(cars.size >= Values.MIN_CAR_COUNT) { "경주에는 자동차 2대 이상이 필요합니다." }
        }

        fun validateAttemptCount(attemptCount: Int) {
            require(attemptCount >= Values.MIN_ATTEMPT_COUNT) { "1번 이상 시도해아 합니다." }
        }
    }
}
