package racingcar.service

import racingcar.model.Car
import racingcar.repository.CarRepository
import racingcar.repository.Repository
import racingcar.utils.END_RANDOM_MOVEMENT_PROBABILITY
import racingcar.utils.MOVEMENT_PROBABILITY
import racingcar.utils.START_RANDOM_MOVEMENT_PROBABILITY

class RacingService(
    private val carRepository: Repository<Car> = CarRepository()
) {
    fun getAll(): List<Car> = carRepository.selectAll()

    fun insertCars(cars: List<Car>) {
        cars.forEach { insertCar(it) }
    }

    private fun insertCar(car: Car) = carRepository.insert(car)

    fun createCars(names: List<String>): List<Car> =
        names.map { Car(it) }

    fun moveRandomly(car: Car) {
        if (isMove()) {
            car.move()
        }
    }

    private fun isMove(): Boolean = (getRandomProbabilityInRange() < MOVEMENT_PROBABILITY)

    private fun getRandomProbabilityInRange(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY).random()

    fun getWinners(cars: List<Car>): List<Car> {
        val winnerStandard = cars.max()
        return cars.filter { it == winnerStandard }
    }
}
