package racingcar

import racingcar.domain.Car
import racingcar.domain.Messages

fun main() {
    Application().run()
}

class Application {
    private val inputValidatorService = InputValidatorService()
    private val raceService = RaceService()
    private val cars = mutableListOf<Car>()

    fun run() {
        startGame()
        print(raceService.getWinner(cars))
    }

    private fun startGame() {
        cars.addAll(getCars())

        val raceCount = getRaceCount()
        println(Messages.GAME_RESULT.message)

        print(raceService.race(raceCount, cars))
    }

    private fun getRaceCount(): Int {
        println(Messages.GAME_INPUT_COUNT.message)
        return inputValidatorService.getValidatedRaceCount(readln())
    }

    private fun getCars(): List<Car> {
        println(Messages.GAME_START.message)
        return inputValidatorService.getValidatedCarNames(readln())
    }
}
