package racingcar.domain

import racingcar.constant.ERROR_INPUT_HANDLER
import racingcar.constant.ERROR_NAME_LENGTH
import racingcar.constant.ERROR_WRONG_NUMBER
import racingcar.domain.MovingDiscriminator.checkGoingForward
import racingcar.domain.numbergenerator.NumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val generator: NumberGenerator,
    private val referee: Referee,
) {
    fun runGame() {
        val names = getCarsName()
        val roundCount = getRoundCount()
        val cars = Cars.from(names)

        OutputView.printResult()
        for (i in 0 until roundCount) {
            playRound(cars.value)
        }

        OutputView.printWinner(referee.getWinner(cars.value))
    }

    fun playRound(cars: List<RacingCar>) {
        cars.forEach {
            play(it)
        }
        OutputView.printEachRound(cars)
    }

    fun play(car: RacingCar) {
        if (checkGoingForward(generator.generate())) {
            car.moveForward()
        }
    }

    fun getCarsName(): List<String> {
        return runCatching {
            getVerifiedCarsName(InputView.getCarsName { OutputView.printGettingCarsName() })
                ?: throw IllegalArgumentException(ERROR_NAME_LENGTH)
        }.getOrElse { error ->
            inputErrorHandler(error, ::getCarsName) as List<String>
        }
    }

    private fun getVerifiedCarsName(input: String): List<String>? {
        val names: List<String>

        if (input.isNotBlank()) {
            names = input.split(",").map { it.trim() }
            checkNameLength(names)
        } else {
            return null
        }

        return names
    }

    fun checkNameLength(value: List<String>) {
        value.forEach {
            require(Validator.isNameLengthInRange(it)) { ERROR_NAME_LENGTH }
        }
    }

    fun getRoundCount(): Int {
        return runCatching {
            getVerifiedRoundCount(InputView.getRoundCount { OutputView.printGettingRoundCount() })
                ?: throw IllegalStateException(
                    ERROR_WRONG_NUMBER,
                )
        }.getOrElse { error ->
            inputErrorHandler(error, ::getRoundCount) as Int
        }
    }

    private fun getVerifiedRoundCount(input: String): Int? {
        if (input.isNotBlank()) {
            require(Validator.isNumber(input)) { ERROR_WRONG_NUMBER }
        } else {
            return null
        }

        return input.toInt()
    }

    private fun inputErrorHandler(
        error: Throwable,
        repeatFunction: () -> Any,
    ): Any {
        return when (error) {
            is IllegalArgumentException -> inputIllegalArgumentExceptionHandler(error, repeatFunction)
            else -> throw IllegalStateException(ERROR_INPUT_HANDLER)
        }
    }

    private fun inputIllegalArgumentExceptionHandler(
        error: Throwable,
        repeatFunction: () -> Any,
    ): Any {
        println(error.message)
        return repeatFunction()
    }
}
