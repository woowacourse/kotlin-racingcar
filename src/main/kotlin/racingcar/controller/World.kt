package racingcar.controller

import racingcar.entity.Name
import racingcar.misc.Util
import racingcar.model.RacingManager
import racingcar.view.InputView
import racingcar.view.OutputView

class World {
    private val racingManager = RacingManager()

    init {
        initCars()
        initAttemptCount()
        run()
        quit()
    }

    private fun initCars() {
        Util.tryAndRerun {
            OutputView.printLnMessage(OutputView.MSG_INPUT_CAR_NAME)
            racingManager.initCars(InputView.carNames().map { Name(it) })
        }
    }

    private fun initAttemptCount() {
        Util.tryAndRerun {
            OutputView.printLnMessage(OutputView.MSG_INPUT_ATTEMPT_COUNT)
            racingManager.setAttemptCount(InputView.attemptCount())
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
