package racingcar.controller

import racingcar.entity.AttemptCount
import racingcar.entity.Name
import racingcar.misc.tryAndRerun
import racingcar.model.CarManager
import racingcar.model.RacingManager
import racingcar.model.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class World {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val racingManager: RacingManager

    init {
        racingManager = RacingManager(initCars(), initAttemptCount())
    }

    private fun initCars(): CarManager {
        return tryAndRerun {
            outputView.printLnMessage(OutputView.MSG_INPUT_CAR_NAME)
            CarManager(RandomNumberGenerator(), inputView.carNames().map { Name(it) })
        } as CarManager
    }

    private fun initAttemptCount(): AttemptCount {
        return tryAndRerun {
            outputView.printLnMessage(OutputView.MSG_INPUT_ATTEMPT_COUNT)
            AttemptCount(inputView.attemptCount())
        } as AttemptCount
    }

    fun run() {
        outputView.printLnMessage(OutputView.MSG_STEP_RESULT)
        outputView.stepResult(racingManager.run())
    }

    fun quit() {
        outputView.printMessage(OutputView.MSG_WINNER)
        outputView.winner(racingManager.determineWinner())
    }
}
