import domain.Cars
import domain.move.RandomMove
import view.InputView
import view.OutputView

fun main() {
    val cars = createCars()
    val numberOfGames = getNumberOfGames()
    startRace(cars, numberOfGames)
    endGame(cars)
}

fun createCars(): Cars {
    OutputView.printInputCarName()
    return try {
        Cars.from(InputView.carNames)
    } catch (e: IllegalArgumentException) {
        OutputView.printException(e.message)
        createCars()
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
