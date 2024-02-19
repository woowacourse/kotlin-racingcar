package racingcar.model

class Winner {
    fun judge(
        car: Car,
        maxPosition: Int,
    ): String? {
        var winner: String? = null

        if (car.position == maxPosition) {
            winner = car.name
        }
        return winner
    }
}
