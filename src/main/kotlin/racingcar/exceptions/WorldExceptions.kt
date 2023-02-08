package racingcar.exceptions

import racingcar.Car

class WorldExceptions {
    fun validateCarCount(cars: List<Car>) {
        require(cars.size > 1) { "경주에는 자동차 2대 이상이 필요합니다." }
    }

    fun validateAttemptCount(attemptCount: Int) {
        require(attemptCount > 0) { "1번 이상 시도해아 합니다." }
    }

    fun validateProcessStep(car: Car, number: Int) {
        checkNotNull(car) { "자동차 객체는 null이 아니어야 합니다." }
        require(number in 0..9) { "생성된 임의 숫자는 0에서 9사이어야 합니다." }
    }
}
