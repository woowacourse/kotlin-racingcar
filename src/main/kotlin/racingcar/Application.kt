package racingcar

import racingcar.domain.Car
import racingcar.domain.Messages

fun main() {
    Application().run()
}

class Application {
    private val inputValidator = InputValidator()
    private val raceService = RaceService()
    private val cars = mutableListOf<Car>()

    fun run() {
        startGame()
        raceService.showCarNamesByWinnerFormat(raceService.getWinCars(cars))
    }

    private fun startGame() {
        cars.addAll(getCars())

        val raceCount = getRaceCount()
        println(Messages.GAME_RESULT.message)

        raceService.repeatRaceByCount(raceCount, cars)
    }

    private fun getRaceCount(): Int {
        println(Messages.GAME_INPUT_COUNT.message)
        return inputValidator.getValidatedRaceCount(readln())
    }

    private fun getCars(): List<Car> {
        println(Messages.GAME_START.message)
        return inputValidator.getValidatedCarNames(readln())
    }
}
