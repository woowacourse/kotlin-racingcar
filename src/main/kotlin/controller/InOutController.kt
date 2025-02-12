package controller

import constant.ErrorConstant
import data.Car
import view.InOutView

class InOutController(val inOutView: InOutView) {
    fun getCarName(): MutableList<Car> {
        val input = inOutView.getCarNames()
        val carNames = input.split(",")
        val cars: MutableList<Car> = mutableListOf()

        carNames.forEach { car ->
            if (cars.find { it.name == car } != null) throw IllegalArgumentException(ErrorConstant.ERROR_SAME_NAME)
            cars.add(Car(car))
        }

        return cars
    }

    fun getTryCount(): Int{
        val input = inOutView.getTryCount().toIntOrNull()
        if(input==null) throw IllegalArgumentException(ErrorConstant.ERROR_NOT_NUMBER)
        if(input<=0) throw IllegalArgumentException(ErrorConstant.ERROR_UNDER_ZERO)
        return input
    }

    fun printCurrentPosition(cars: MutableList<Car>) {
        cars.forEach { car ->
            inOutView.printCurrentResult(car)
        }
        println()
    }

    fun printGameResult() {
        inOutView.printGameResult()
    }

    fun printFinalResult(winnerResult: MutableList<String>){
        inOutView.printFinalResult(winnerResult)

    }
}