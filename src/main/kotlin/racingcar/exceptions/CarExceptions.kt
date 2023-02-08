package racingcar.exceptions

import racingcar.Car

class CarExceptions {
    fun validateCompareTo(car: Car) {
        checkNotNull(car) { "비교할 자동차 객체는 null이 아니어야 합니다. " }
    }
}
