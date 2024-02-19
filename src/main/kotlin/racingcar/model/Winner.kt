package racingcar.model

class Winner {
    fun judgeWinners(
        car: Car,
        maxPosition: Int,
        winners: MutableList<String>,
    ) {
        if (car.position == maxPosition) {
            winners.add(car.name)
        }
    }
}