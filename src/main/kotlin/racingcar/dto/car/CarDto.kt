package racingcar.dto.car

import racingcar.model.car.CarName

class CarDto(_carName: String, val position: Int = 0) {
    val carName: CarName = CarName(_carName.trim())
}
