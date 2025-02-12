package model

import data.Car
import java.util.Random

class Repository(private var cars: MutableList<Car>) {
    var winnerList: MutableList<Car> = mutableListOf()

    fun getCars(): MutableList<Car> {
        return cars
    }

    fun moveCar(car: Car) {
        car.currentPosition += goOrNot()
    }

    private fun goOrNot(): Int {
        var nowNumber = Random().nextInt(10)

        if (nowNumber >= 4) return 1
        return 0
    }

    fun comparePosition(): MutableList<Car> {
        var maxPosition = cars.map { it.currentPosition }.max()
        winnerList = cars.filter { it.currentPosition == maxPosition }.toMutableList()
        return winnerList
    }
}