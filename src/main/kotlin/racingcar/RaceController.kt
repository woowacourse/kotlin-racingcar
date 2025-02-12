package racingcar

class RaceController {
    private val inputView = InputView()
    private val outputView = OutputView()


    fun run() {
        val rawCarNames = inputView.insertCarNames()
        val rawTryCount = inputView.insertTryCount()

        val race = Race(rawCarNames, rawTryCount)
        race.moveOrStops()
        val winners = race.getWinners()


        outputView.printRoundResult(race.cars.map { it.carName }, race.cars.map { it.moveOrStop }, race.tryCount)
        outputView.printWinners(winners)
    }
}