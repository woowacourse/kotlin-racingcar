import domain.CarFactory
import domain.Referee
import view.InputView
import view.OutputView

private const val EXCEPTION_NULL = "[ERROR] exception 메시지가 null입니다."

class GameController() {
    private lateinit var carFactory: CarFactory
    private var tryCount: Int = 0

    fun runGame() {
        standByPhase()
        playingPhase()
        endPhase()
    }

    private fun standByPhase() {
        makeCars()
        tryCount = getValidTryCount()
    }

    private fun playingPhase() {
        OutputView.printResultMessage()
        playRace()
    }

    private fun endPhase() {
        val winnersResult = Referee.judgeWinner(carFactory.cars)
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

    private fun makeCars() {
        return try {
            carFactory = CarFactory(enterCarName())
        } catch (e: IllegalArgumentException) {
            OutputView.printErrorMessage(e.message ?: EXCEPTION_NULL)
            makeCars()
        }
    }

    private fun playRace() {
        repeat(tryCount) {
            carFactory.moveCars()
            OutputView.printResult(carFactory.cars)
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
