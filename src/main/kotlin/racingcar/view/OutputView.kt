package racingcar.view

import racingcar.domain.Car

class OutputView {
    fun printRoundResult(cars : List<Car>){
        cars.forEach{
            println("${it.name} : ${"-".repeat(it.position)}")
        }
    }
}