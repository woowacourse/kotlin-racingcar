package racingcar

class RacingGame {

    fun play() {
        val cars = createCarsByInputNames()
        val randoms = Randoms(cars.cars.size)
        progressRounds(cars, randoms)
        val gameResult = GameResult(cars)
        printFinalResult(gameResult.pickWinners())
    }

    private fun progressRounds( cars: Cars, randoms: Randoms) {
        val rounds = getIntegerRounds()
        printResultMessage()
        for (round in 0 until rounds) {
            cars.moveAll(randoms.generate(0, 10))
            printCurrentResult(cars.cars)
        }
    }

    private fun createCarsByInputNames(): Cars {
        return try {
            Cars.of(inputNames())
        } catch (e: IllegalArgumentException) {
            e.message?.let { printMessage(it) }
            createCarsByInputNames()
        }
    }

    private fun getIntegerRounds(): Int {
        return try {
            inputRounds()
        } catch (e: IllegalArgumentException) {
            e.message?.let { printMessage(it) }
            getIntegerRounds()
        }
    }
}
