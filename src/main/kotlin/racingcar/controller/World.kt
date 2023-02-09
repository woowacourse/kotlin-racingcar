package racingcar.controller

import racingcar.Util
import racingcar.model.RacingManager
import racingcar.view.InputView
import racingcar.view.OutputView

class World {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val racingManager = RacingManager()

    init {
        initCars()
        initAttemptCount()
        run()
        quit()
    }

    private fun initCars() {
        Util.tryAndRerun {
            outputView.printMessage(OutputView.MSG_INPUT_CAR_NAME)
            val names = inputView.carNames()
            racingManager.initCars(names)
        }
    }

    private fun initAttemptCount() {
        Util.tryAndRerun {
            outputView.printMessage(OutputView.MSG_INPUT_ATTEMPT_COUNT)
            val attemptCount = inputView.attemptCount()
            racingManager.setAttemptCount(attemptCount)
        }
    }

    private fun run() {
        outputView.printMessage(OutputView.MSG_STEP_RESULT)
        outputView.stepResult(racingManager.run())
    }

    private fun quit() {
        outputView.winner(racingManager.determineWinner())
    }
}
