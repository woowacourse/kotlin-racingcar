package racingcar.model

class Winner {
    fun judgeWinners(
        car: Car,
        maxPosition: Int,
    ): MutableList<String> {
        val winners = mutableListOf<String>()

        if (car.position == maxPosition) {
            winners.add(car.name)
        }
        return winners
    }
}
