package racingcar

class RacingGame {

    fun play() {
        val names = inputNames()
        val cars = Cars.of(names)

        val randoms = Randoms(cars.cars.size)
        val rounds = inputRounds()
        printResultMessage()
        for (round in 0 until rounds) {
            cars.moveAll(randoms.generate(0, 10))
            printCurrentResult(cars.cars)
        }
        val gameResult = GameResult(cars)
        printFinalResult(gameResult.pickWinners())
    }
}
