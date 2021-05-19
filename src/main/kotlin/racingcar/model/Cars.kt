package racingcar.model

import racingcar.util.RandomUtil

class Cars(val cars: List<Car>) {

    fun moveAll() {
        for (car in cars) {
            car.move(RandomUtil.generateRandomNumber())
        }
    }
}
