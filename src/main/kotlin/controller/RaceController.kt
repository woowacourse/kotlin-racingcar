package controller

import data.Car
import java.util.Random

class RaceController(val count: Int, val cars: MutableList<Car>) {
    fun fullRace() {
        for (time in 1..count) {
            oneRace()
        }
    }

    fun oneRace() {
        for (car in cars) {
            car.currentPosition += goOrNot()
        }
    }



    fun goOrNot(): Int {

        var nowNumber = Random(10).nextInt()
        if (nowNumber >= 4) {
            return 1
        }
        return 0
    }
}