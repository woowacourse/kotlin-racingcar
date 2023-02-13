package racingcar.dto.car

import racingcar.model.car.Car

class WinnersDto(winners: List<Car>) : List<Car> by winners
