import racingCar.domain.Cars
import racingCar.domain.move.RandomMove
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val cars = createCars()
    var numberOfGames = getNumberOfGames()
    startRace(cars, numberOfGames)
    endGame(cars)
}

fun createCars(): Cars {
    OutputView.printInputCarName()
    try {
        return Cars.from(InputView.carNames)
    } catch (e: IllegalArgumentException) {
        OutputView.printException(e.message)
        return createCars()
    }
}

fun getNumberOfGames(): Int {
    OutputView.printInputNumberOfGames()
    try {
        return InputView.numberOfGames
    } catch (e: IllegalArgumentException) {
        OutputView.printException(e.message)
        return getNumberOfGames()
    }
}

fun startRace(cars: Cars, numberOfGames: Int) {
    OutputView.printResultMessage()
    for (round in 0 until numberOfGames) {
        cars.moveCars(RandomMove())
        OutputView.printGameResult(cars.cars)
    }
}

fun endGame(cars: Cars) {
    OutputView.printWinners(cars.getWinners())
}
