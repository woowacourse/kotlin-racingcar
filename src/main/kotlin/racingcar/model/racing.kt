package racingcar.model

import racingcar.view.printProgress
import kotlin.math.max


const val START_RANGE = 0
const val END_RANGE = 9
const val TARGET_NUM = 4

fun move(cars: MutableList<Car>) {
    for (car in cars) {
        val randomNum = rand()
        if (goOrStop(randomNum)) car.position++
    }
    printProgress(cars)
}

fun rand() = (START_RANGE..END_RANGE).random()

fun goOrStop(num: Int): Boolean {
    if (num >= TARGET_NUM) return true
    return false
}

fun findWinnerNames(cars: List<Car>): List<String> {
    var maxNum = -1
    val winners = mutableListOf<String>()
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
    val pos = car.position
    val num = max(pos, tmp)
    if (tmp < num) {
        winners.clear()
        winners.add(car.name)
    } else if (tmp == pos) winners.add(car.name)
    return num
}