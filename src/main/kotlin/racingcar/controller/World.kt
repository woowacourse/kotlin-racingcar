package racingcar.controller

import racingcar.entity.Name
import racingcar.misc.Util
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
            outputView.printLnMessage(OutputView.MSG_INPUT_CAR_NAME)
            racingManager.initCars(inputView.carNames().map { Name(it) })
        }
    }

    private fun initAttemptCount() {
        Util.tryAndRerun {
            outputView.printLnMessage(OutputView.MSG_INPUT_ATTEMPT_COUNT)
            racingManager.setAttemptCount(inputView.attemptCount())
        }
    }

    private fun run() {
        outputView.printLnMessage(OutputView.MSG_STEP_RESULT)
        outputView.stepResult(racingManager.run())
    }

    private fun quit() {
        outputView.printMessage(OutputView.MSG_WINNER)
        outputView.winner(racingManager.determineWinner())
    }
}
