package racingcar.model

class Winner {
    fun judgeWinners(
        car: Car,
        maxPosition: Int,
    ): String {
        lateinit var winners: String

        if (car.position == maxPosition) {
            winners = car.name
        }
        return winners
    }
}
