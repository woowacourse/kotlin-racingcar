package racingcar.model.car

import racingcar.model.car.move.step.MoveStep

class Car(name: String, private var _position: Int = 0) {
    val carName: CarName = CarName(name)
    val position: Int get() = _position

    fun move(moveStep: MoveStep) {
        _position += moveStep.move()
    }
}
