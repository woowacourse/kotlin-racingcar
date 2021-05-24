package controller

import domain.Car
import domain.Cars
import view.View
import view.ViewValidator
import kotlin.random.Random

const val RANDOM_BOUNDARY = 4
const val RANDOM_MAX = 10

class GameController(private val view: View) {
    fun gameStart() {
        val validator = ViewValidator()
        val carNames = validator.validCarNames(view.inputNumCar())
        val numMatch = validator.validNumMatch(view.inputNumMatch())
        val cars = createCars(carNames)
        val random = Random

        println("실행 결과")
        for (i in 0 until numMatch) {
            cars.randomMove(random, randomMax = RANDOM_MAX, boundary = RANDOM_BOUNDARY)
            view.printCarScore(cars)
        }
        view.printWinner(Winner(cars).findWinnerNames())
    }

    private fun createCars(carNames: String): Cars =
        Cars(carNames.split(",").map { Car(it, 0) })
}
