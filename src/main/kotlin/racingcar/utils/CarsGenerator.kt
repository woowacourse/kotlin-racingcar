package racingcar.utils

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.ui.getCarNamesByUser
import racingcar.ui.printErrorMessage

fun getCarInput(): Cars {
    val userInput = getCarNamesByUser()
    return try {
        Cars(generateCars(userInput))
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message)
        getCarInput()
    }
}

fun generateCars(userInput: String?): List<Car> {
    val carNames = separateCarNames(userInput)
    return carNames
        .map(::Car)
}

private fun separateCarNames(userInput: String?): List<String> {
    return userInput!!.split(",")
}
