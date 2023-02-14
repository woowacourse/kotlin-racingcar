package racingcar.controller

import racingcar.entity.Name
import racingcar.model.AttemptCount
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
            OutputView.requestCarName()
            InputView.carNames().map { Name(it) }
        } catch (e: IllegalArgumentException) {
            println("[ERROR]: " + e.message)
            initCars()
        }
    }

    private fun initAttemptCount(): AttemptCount {
        return try {
            OutputView.requestAttemptCount()
            AttemptCount(InputView.attemptCount())
        } catch (e: IllegalArgumentException) {
            println("[ERROR]: " + e.message)
            initAttemptCount()
        }
    }

    private fun run() {
        OutputView.printStepResult()
        OutputView.stepResult(racingManager.run())
    }

    private fun quit() {
        OutputView.printWinners()
        OutputView.winner(racingManager.determineWinner())
    }
}
