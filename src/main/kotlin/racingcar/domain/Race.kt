package racingcar.domain

class Race(rawCarNames: String, rawTryCount: String) {
    val tryCount = rawTryCount.toInt()
    val cars = rawCarNames.split(",").map { Car(it) }

    private fun isMove(randomNumber: Int): Boolean {
        return randomNumber in 3..9
    }

    fun moveOrStops() {
        val generateRandomNumber = GenerateRandomNumber()
        repeat(tryCount) {
            cars.forEach { car ->
                val randomNumber = generateRandomNumber.randomNumber()
                car.moves(isMove(randomNumber))
            }
        }
    }

    fun getWinners(): List<String> {
        val maxNumber = cars.maxOfOrNull { it.moveCount() }
        val winners =
            cars.filter { car ->
                car.moveCount() == maxNumber
            }.map { it.carName }
        return winners
    }
}
