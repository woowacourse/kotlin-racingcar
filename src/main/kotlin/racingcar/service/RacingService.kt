package racingcar.service

import racingcar.model.Car
import racingcar.repository.CarRepository
import racingcar.repository.Repository

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

    fun getWinners(): List<Car> {
        val cars = getAll()
        val winnerStandard = cars.maxBy { it.position }
        return cars.filter { it.position == winnerStandard.position }
    }

    companion object {
        private const val START_RANDOM_MOVEMENT_PROBABILITY = 1
        private const val END_RANDOM_MOVEMENT_PROBABILITY = 10
        private const val MOVEMENT_PROBABILITY = 4
    }
}
