package racingcar

import kotlin.random.Random

fun main() {
    Application.run()
}

class Application {
    companion object {
        fun run() {
            val inputValidator = InputValidator()

            println(Messages.GAME_START.message)
            val namesInput = readln()
            inputValidator.carNamesValidate(namesInput)
            val names: List<String> = namesInput.split(",")

            println(Messages.GAME_INPUT_COUNT.message)
            val raceCountInput = readln()
            inputValidator.tryCountValidate(raceCountInput)
            val raceCount: Int = raceCountInput.toInt()
            val cars = toCars(names)

            result(raceCount, cars)
            getWinner(cars)
        }

        private fun toCars(names: List<String>): List<Car> {
            val random = Random(13413)
            return names.map { Car(it, random) }
        }

        private fun result(
            raceCount: Int,
            cars: List<Car>,
        ) {
            println(Messages.GAME_RESULT.message)
            for (i in 0 until raceCount) {
                race(cars)
                println()
            }
        }

        private fun getWinner(cars: List<Car>) {
            val winners = cars.filter { it.distance == cars.maxOf { car -> car.distance } }
            println("최종 우승자 :  ${winners.joinToString(", ") {it.name}}")
        }

        private fun race(cars: List<Car>) {
            cars.forEach {
                it.randomMove()
                it.printDistanceInfo()
            }
        }
    }
}
