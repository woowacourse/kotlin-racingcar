package racingcar.controller

import racingcar.entity.Name
import racingcar.model.RacingManager
import racingcar.view.InputView
import racingcar.view.OutputView

class World {
    private val racingManager = RacingManager(initCars(), initAttemptCount())

    init {
        run()
        quit()
    }

    private fun initCars(): List<Name> {
        return try {
            OutputView.printLnMessage(OutputView.MSG_INPUT_CAR_NAME)
            InputView.carNames().map { Name(it) }
        } catch (e: IllegalArgumentException) {
            println("[ERROR]: " + e.message)
            initCars()
        }
    }

    private fun initAttemptCount(): Int {
        return try {
            OutputView.printLnMessage(OutputView.MSG_INPUT_ATTEMPT_COUNT)
            InputView.attemptCount()
        } catch (e: IllegalArgumentException) {
            println("[ERROR]: " + e.message)
            initAttemptCount()
        }
    }

    private fun run() {
        OutputView.printLnMessage(OutputView.MSG_STEP_RESULT)
        OutputView.stepResult(racingManager.run())
    }

    private fun quit() {
        OutputView.printMessage(OutputView.MSG_WINNER)
        OutputView.winner(racingManager.determineWinner())
    }
}
