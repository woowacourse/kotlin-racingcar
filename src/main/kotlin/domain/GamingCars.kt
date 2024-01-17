package domain

import util.RandomNumberFactory

class GamingCars(val cars: List<Car>) {

    fun gameStart(count: Int) {
        for (i in 0..count) {
            cars.forEach {
                it.movingForward(RandomNumberFactory.create())
            }
        }
    }
}