package racingcar.model.car

class Winners(winners: List<Car>) : List<Car> by winners {
    fun toDto(): WinnersDto = WinnersDto(this)
}

class WinnersDto(winners: List<Car>) : List<Car> by winners
