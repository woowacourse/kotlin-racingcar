package racingcar.view

import racingcar.model.Car

fun printRunMenu(){
    println("실행 결과")
}

fun printProgress(cars: List<Car>) {
    for (car in cars) {
        // car.position 값만큼 "-"를 반복하여 출력
        val progress = "-".repeat(car.position)
        println("${car.name} : $progress")
    }
    println()
}

fun printWinners(winners:List<String>){
    print("최종 우승자 : ${winners.joinToString(", ")}")
}