import domain.Cars
import view.InputView
import view.OutputView

fun main() {
    val cars = getCars()
    val raceCount = getRaceCount()

    OutputView.printResultTitle()
    for (i in 1..raceCount) {
        cars.moveAll()
        OutputView.printRaceResult(cars)
    }

    OutputView.printWinner(cars.findWinners())
}


private fun getCars(): Cars {
    return try {
        val carNames = InputView.inputCarNames()
        Cars(carNames)
    } catch (e: RuntimeException) {
        OutputView.printException(e)
        getCars()
    }

}

private fun getRaceCount(): Int {
    return try {
        InputView.inputRaceCount()
    } catch (e: RuntimeException) {
        OutputView.printException(e)
        getRaceCount()
    }
}
