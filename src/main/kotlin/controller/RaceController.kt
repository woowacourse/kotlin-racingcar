package controller

import data.Car
import java.util.Random

class RaceController(val count: Int, val cars: MutableList<Car>, val inOutController: InOutController) {
    fun fullRace() {
        inOutController.printGameResult()
        repeat(count) {
            oneRace()
        }
    }
    fun comparePosition():MutableList<String>{
        var winnerList: MutableList<String> = mutableListOf()
        var maxPosition = 0
        for (car in cars){
            if(car.currentPosition==maxPosition){
                winnerList.add(car.name)
            }
            if(car.currentPosition>maxPosition){
                winnerList=mutableListOf(car.name)
                maxPosition=car.currentPosition
            }
        }
        return winnerList
    }
    private fun oneRace() {
        for (car in cars) {
            car.currentPosition += goOrNot()
        }
        inOutController.printCurrentPosition(cars)
    }

    private fun goOrNot(): Int {
        var nowNumber = Random().nextInt(10)

        if (nowNumber >= 4) return 1
        return 0
    }
}