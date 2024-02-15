package racingcar.view

import racingcar.model.Car

fun printProgress(cars : List<Car>) {
    println("실행 결과")
    for(car in cars){
        println("${car.name} : ${car.position}")
    }
    println()
}

fun printWinners(winners:List<String>){
    print("최종 우승자 : ${winners.joinToString(", ")}")
}