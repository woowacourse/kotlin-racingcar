package model

import data.Car
import java.util.Random

class Repository(private var cars: MutableList<Car>,private val random: Random) {
    private var winnerList: MutableList<Car> = mutableListOf()

    fun getCars(): MutableList<Car> {
        return cars
    }

    fun moveCar(car: Car) {
        car.currentPosition += goOrNot()
    }

    private fun goOrNot(): Int {
        val nowNumber = random.nextInt(10)

        if (nowNumber >= 4) return 1
        return 0
    }

    fun comparePosition(): MutableList<Car> {
        val maxPosition = cars.map { it.currentPosition }.max()
        winnerList = cars.filter { it.currentPosition == maxPosition }.toMutableList()
        return winnerList
    }
}