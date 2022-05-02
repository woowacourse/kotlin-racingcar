import racingCar.domain.Cars
import racingCar.domain.move.RandomMove
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val cars = createCars()
    startRace(cars, getNumberOfGames())
    endGame(cars)
}

tailrec fun createCars(): Cars {
    OutputView.printInputCarName()
    return try {
        Cars.from(InputView.carNames)
    } catch (e: IllegalArgumentException) {
        OutputView.printException(e.message)
        createCars()
    }
}

tailrec fun getNumberOfGames(): Int {
    OutputView.printInputNumberOfGames()
    return try {
        InputView.numberOfGames
    } catch (e: IllegalArgumentException) {
        OutputView.printException(e.message)
        getNumberOfGames()
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
