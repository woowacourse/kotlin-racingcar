package racingcar.domain

import racingcar.service.RacingService

class Cars(
    val cars: List<Car>
) {
    init {
        require(isNotDuplicatedCarNames()) { DUPLICATED_CAR_NAME_ERROR_MESSAGE }
    }

    fun moveCarsRandomly() {
        cars.forEach { car ->
            val racingService = RacingService()
            racingService.moveRandomly(car)
        }
    }

    fun getWinners(): Cars {
        val winnerStandard: Car = cars.max()
        val winners = cars.filter { it == winnerStandard }
        return Cars(winners)
    }

    private fun isNotDuplicatedCarNames(): Boolean = cars.distinct().size == cars.size

    companion object {
        private const val DUPLICATED_CAR_NAME_ERROR_MESSAGE = "자동차 이름 중복 빼주세요~"
    }
}
