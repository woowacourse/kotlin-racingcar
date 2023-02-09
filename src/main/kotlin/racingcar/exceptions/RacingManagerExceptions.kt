package racingcar.exceptions

import racingcar.model.Car

class RacingManagerExceptions {
    fun validateStep(number: Int) {
        require(number in 0..9) { "생성된 임의 숫자는 0에서 9사이어야 합니다." }
    }

    fun validateCarCount(cars: List<Car>) {
        require(cars.size > 1) { "경주에는 자동차 2대 이상이 필요합니다." }
    }

    fun validateAttemptCount(attemptCount: Int) {
        require(attemptCount > 0) { "1번 이상 시도해아 합니다." }
    }
}
