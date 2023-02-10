package racingcar.controller

import racingcar.entity.AttemptCount
import racingcar.entity.Car
import racingcar.entity.Name
import racingcar.misc.tryAndRerun
import racingcar.model.CarManager
import racingcar.model.RacingManager
import racingcar.model.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class World {
    private val outputView: OutputView = OutputView()
    private val inputView: InputView = InputView()
    private val racingManager: RacingManager

    init {
        racingManager = RacingManager(initCars(), initAttemptCount())
    }

    private fun initCars(): CarManager {
        return tryAndRerun {
            outputView.printLnMessage(OutputView.MSG_INPUT_CAR_NAME)
            val names = inputView.carNames().map { Name(it) }
            val cars = names.map { Car(it) }
            CarManager(RandomNumberGenerator(), cars)
        } as CarManager
    }

    private fun initAttemptCount(): AttemptCount {
        return tryAndRerun {
            outputView.printLnMessage(OutputView.MSG_INPUT_ATTEMPT_COUNT)
            val attemptCount = inputView.attemptCount()
            AttemptCount(attemptCount)
        } as AttemptCount
    }

    fun startRace() {
        val attemptHistory = racingManager.run()
        outputView.attemptHistory(attemptHistory)
    }

    fun finishRace() {
        val winner = racingManager.determineWinner()
        outputView.winner(winner)
    }
}
