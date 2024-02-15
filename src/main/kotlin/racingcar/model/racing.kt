package racingcar.model

val START_RANGE = 0
val END_RANGE = 9
val TARGET_NUM = 4
fun move(cars: MutableList<Car>) {
    val randomNum = rand()

    for (car in cars) {
        car.position += goOrStop(randomNum)
    }

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
    maxNum: Int,
    winners: MutableList<String>
): Int {
    var tmp = maxNum
    var num = Math.max(car.position.length, tmp)
    if (tmp < num) {
        tmp = num
        winners.add(car.name)
    }
    return tmp
}