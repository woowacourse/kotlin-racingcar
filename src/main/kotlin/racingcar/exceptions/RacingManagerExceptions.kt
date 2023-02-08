package racingcar.exceptions

import racingcar.model.Car

class RacingManagerExceptions {
    fun validateProcessStep(car: Car, number: Int) {
        require(number in 0..9) { "생성된 임의 숫자는 0에서 9사이어야 합니다." }
    }
}
