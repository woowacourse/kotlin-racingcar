import domain.Car
import domain.Driver
import domain.Referee
import domain.numbergenerator.RandomNumberGenerator
import view.InputView
import view.OutputView

private const val EXCEPTION_NULL = "[ERROR] exception 메시지가 null입니다."

class GameController() {
    private var cars: List<Car> = emptyList()
    private var tryCount: Int = 0

    fun runGame() {
        standByPhase()
        playingPhase()
        endPhase()
    }

    private fun standByPhase() {
        val driver = Driver(RandomNumberGenerator())
        cars = getValidCar(driver)
        tryCount = getValidTryCount()
    }

    private fun playingPhase() {
        OutputView.printResultMessage()
        playRace()
    }

    private fun endPhase() {
        val winnersResult = Referee.judgeWinner(cars)
        OutputView.printWinner(winnersResult)
    }

    private fun getValidTryCount(): Int {
        return try {
            enterTryCount()
        } catch (e: IllegalArgumentException) {
            OutputView.printErrorMessage(e.message ?: EXCEPTION_NULL)
            getValidTryCount()
        }
    }

    private fun getValidCar(driver: Driver): List<Car> {
        return try {
            val carNames = enterCarName()
            carNames.map { Car(it, driver) }
        } catch (e: IllegalArgumentException) {
            OutputView.printErrorMessage(e.message ?: EXCEPTION_NULL)
            getValidCar(driver)
        }
    }

    private fun playRace() {
        repeat(tryCount) {
            moveAllCar()
            OutputView.printResult(cars)
        }
    }

    private fun moveAllCar() {
        cars.forEach {
            it.move()
        }
    }

    private fun enterTryCount(): Int {
        OutputView.printEnterTryCount()
        tryCount = InputView.enterTryCount()
        return tryCount
    }

    private fun enterCarName(): List<String> {
        OutputView.printEnterCarName()
        return InputView.enterCarName()
    }
}
