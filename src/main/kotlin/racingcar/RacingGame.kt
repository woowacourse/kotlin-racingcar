package racingcar

class RacingGame {

    fun play() {
        val cars = createCarsByInputNames()
        progressRounds(cars)
        val gameResult = GameResult(cars)
        printFinalResult(gameResult.pickWinners())
    }

    private fun progressRounds(cars: Cars) {
        val randoms = Randoms(cars.cars.size)
        val rounds = getIntegerRounds()
        printResultMessage()
        for (round in 1..rounds) {
            cars.moveAll(randoms.generate())
            printCurrentResult(cars.cars)
        }
    }

    private fun createCarsByInputNames(): Cars {
        return try {
            Cars.of(inputNames())
        } catch (e: IllegalArgumentException) {
            e.message?.let(::printMessage)
            createCarsByInputNames()
        }
    }

    private fun getIntegerRounds(): Int {
        return try {
            inputRounds()
        } catch (e: NumberFormatException) {
            e.message?.let(::printMessage)
            getIntegerRounds()
        }
    }
}
