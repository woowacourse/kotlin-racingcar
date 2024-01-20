package domain

import util.RandomNumberFactory

class GamingCars(val cars: List<Car>) {

    fun movingForward() {
        cars.forEach { car: Car ->
            car.movingForward(RandomNumberFactory.create())
        }
    }


    private fun calcMaxDistance(): Int {
        return cars
            .maxBy { car: Car -> car.distance }
            .distance
    }

    fun calcWinnerCars(): List<Car> {
        val maxDistance = calcMaxDistance()
        //우승 Car list를 뽑아야함.
        return cars.filter { car: Car -> car.distance == maxDistance }
    }
}