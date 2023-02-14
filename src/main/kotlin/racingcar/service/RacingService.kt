package racingcar.service

import racingcar.dto.car.CarsDto
import racingcar.dto.car.WinnersDto
import racingcar.dto.round.RoundDto
import racingcar.model.car.move.condition.CarMoveCondition
import racingcar.model.car.move.condition.CarRandomMoveCondition
import racingcar.utils.mapper.toDto
import racingcar.utils.mapper.toModel

class RacingService(
    _cars: CarsDto,
    private val carMoveCondition: CarMoveCondition = CarRandomMoveCondition()
) {
    private val cars = _cars.toModel()

    fun runAllRounds(round: RoundDto, doEachRoundResult: (CarsDto) -> Unit) {
        repeat(round.toModel().count) {
            doEachRoundResult(moveCars())
        }
    }

    private fun moveCars(): CarsDto =
        cars.moveAll(carMoveCondition).toDto()

    fun getWinners(): WinnersDto = cars.getWinners().toDto()
}
