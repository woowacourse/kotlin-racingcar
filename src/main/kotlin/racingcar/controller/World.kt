package racingcar.controller

import racingcar.Util
import racingcar.exceptions.WorldExceptions
import racingcar.model.Car
import racingcar.model.RacingManager
import racingcar.view.InputView
import racingcar.view.OutputView

class World {
    val cars = mutableListOf<Car>()
    var attemptCount = 0
    private val outputView = OutputView()
    private val inputView = InputView()
    private val exceptions = WorldExceptions()
    private val racingManager = RacingManager()

    fun init() {
        initCar()
        initAttemptCount()
    }

    private fun initCar() {
        Util.tryAndRerun {
            outputView.printMessage(OutputView.MSG_INPUT_CAR_NAME)
            val names = inputView.carNames()
            for (name in names) {
                cars.add(Car(name))
            }
            exceptions.validateCarCount(cars)
        }
    }

    private fun initAttemptCount() {
        Util.tryAndRerun {
            outputView.printMessage(OutputView.MSG_INPUT_ATTEMPT_COUNT)
            attemptCount = inputView.attemptCount()
            exceptions.validateAttemptCount(attemptCount)
        }
    }

    fun run() {
        for (i in 0 until attemptCount) {
            attempt()
        }
    }

    private fun attempt() {
        for (i in 0 until cars.size) {
            racingManager.processStep(cars[i], Util.generateRandom())
        }
        outputView.printMessage(OutputView.MSG_STEP_RESULT)
        outputView.stepResult(cars)
    }

    fun quit() {
        outputView.winner(racingManager.determineWinner(cars))
    }
}
