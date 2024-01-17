package domain

import util.RandomNumberFactory

class GamingCars(val cars: List<Car>) {

    fun movingForward() {
        cars.forEach {
            it.movingForward(RandomNumberFactory.create())
        }
    }
}