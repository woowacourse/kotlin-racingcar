package racingcar

class Controller(
    private val raceService: RaceService,
) {
    private val view = View()

    fun run() {
        val cars = view.getCars()
        val raceCount = view.getRaceCount()

        view.printResult(raceService.race(raceCount, cars))
        view.printWinner(raceService.getWinner(cars))
    }
}
