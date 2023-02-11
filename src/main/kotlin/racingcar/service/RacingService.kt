package racingcar.service

import racingcar.model.car.CarsDto
import racingcar.model.car.WinnersDto
import racingcar.model.round.RoundDto

class RacingService(_cars: CarsDto, _round: RoundDto) {
    private val cars = _cars.toModel()
    private val round = _round.toModel()

    fun runAllRounds(doEachRoundResult: (CarsDto) -> Unit) {
        repeat(round.count) {
            doEachRoundResult(moveCarsRandomly())
        }
    }

    private fun moveCarsRandomly(): CarsDto = cars.moveAllRandomly().toDto()

    fun getWinners(): WinnersDto = cars.getWinners().toDto()
}
