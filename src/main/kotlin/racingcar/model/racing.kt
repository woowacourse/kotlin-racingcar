package racingcar.model

import racingcar.view.printProgress

val START_RANGE = 0
val END_RANGE = 9
val TARGET_NUM = 4
fun move(cars: MutableList<Car>) {
    for (car in cars) {
        val randomNum = rand()
        car.position += goOrStop(randomNum)
    }
    printProgress(cars)
}

fun rand() = (START_RANGE..END_RANGE).random()

fun goOrStop(num: Int): String {
    if (num >= TARGET_NUM) return "-"
    return ""
}

fun findWinnerNames(cars: List<Car>): List<String> {
    var maxNum = -1
    var winners = mutableListOf<String>()
    for (car in cars) {
        maxNum = winnerJudge(car, maxNum, winners)
    }

    return winners
}

private fun winnerJudge(
    car: Car,
    tmp: Int,
    winners: MutableList<String>
): Int {
    val len = car.position.length
    var num = Math.max(len, tmp)
    if (tmp < num) {
        winners.clear()
        winners.add(car.name)
    } else if (tmp == len) winners.add(car.name)
    return num
}