package racingcar.service

import racingcar.dto.car.CarsDto
import racingcar.model.car.WinnersDto
import racingcar.model.round.RoundDto
import racingcar.utils.mapper.toDto
import racingcar.utils.mapper.toModel
import racingcar.utils.random.MovementProbabilityGenerator
import racingcar.utils.random.RandomGenerator

class RacingService(
    _cars: CarsDto,
    private val movementProbabilityGenerator: RandomGenerator = MovementProbabilityGenerator()
) {
    private val cars = _cars.toModel()

    fun runAllRounds(round: RoundDto, doEachRoundResult: (CarsDto) -> Unit) {
        repeat(round.toModel().count) {
            doEachRoundResult(moveCarsRandomly())
        }
    }

    private fun moveCarsRandomly(): CarsDto =
        cars.moveAllRandomly(movementProbabilityGenerator).toDto()

    fun getWinners(): WinnersDto = cars.getWinners().toDto()
}
