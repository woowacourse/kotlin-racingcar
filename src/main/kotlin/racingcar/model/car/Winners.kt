package racingcar.model.car

import racingcar.dto.car.WinnersDto

class Winners(winners: List<Car>) : List<Car> by winners {
    fun toDto(): WinnersDto = WinnersDto(this)
}
