package racingcar.model

class Winner {
    fun judgeWinners(
        car: Car,
        maxPosition: Int,
    ): String? {
        var winners: String? = null

        if (car.position == maxPosition) {
            winners = car.name
        }
        return winners
    }
}
