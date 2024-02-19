package racingcar.view

import racingcar.model.Car

private const val RATIO="-"

fun printRunMenu(){
    println("실행 결과")
}

fun printProgress(cars: List<Car>) {
    for (car in cars) {
        val progress = RATIO.repeat(car.position)
        println("${car.name} : $progress")
    }
    println()
}

fun printWinners(winners:List<String>){
    print("최종 우승자 : ${winners.joinToString(", ")}")
}