package racingcar.repository

import racingcar.model.car.Car

class CarRepository : Repository<Car> {
    private val cars = arrayListOf<Car>()

    override fun selectAll(): List<Car> = cars

    override fun insert(item: Car) {
        require(cars.none { it.carName.name == item.carName.name }) { DUPLICATED_CAR_NAME_ERROR_MESSAGE }
        cars.add(item)
    }

    companion object {
        private const val DUPLICATED_CAR_NAME_ERROR_MESSAGE =
            "중복된 자동차 이름이 존재합니다."
    }
}
