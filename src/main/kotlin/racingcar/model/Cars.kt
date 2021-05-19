package racingcar.model

import racingcar.util.RandomUtil

class Cars(val cars: List<Car>) {

    fun moveAll(): Cars {
        val cars = arrayListOf<Car>()
        for (car in this.cars) {
            cars.add(car.move(RandomUtil.generateRandomNumber()))
        }
        return Cars(cars)
    }
}
