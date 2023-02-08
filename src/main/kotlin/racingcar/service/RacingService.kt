package racingcar.service

import racingcar.model.Car
import kotlin.random.Random

class RacingService {

    fun createCar(carName: String) = Car(carName)

    fun moveRandomly(car: Car) {
        if (isMove()) {
            car.move()
        }
    }

    private fun isMove(): Boolean {
        val random = Random.nextInt(10)
        if (random < 4) {
            return false
        }
        return true
    }

    fun getWinners(cars: List<Car>): List<Car> {
        val winnerStandard = cars.max()
        return cars.filter { it == winnerStandard }
    }
}
