package racingcar.utils

import racingcar.domain.Car
import racingcar.domain.validateCarName
import racingcar.ui.getCarNamesByUser
import racingcar.ui.printErrorMessage
import racingcar.validator.validateCarNames

fun getCarNamesInput(): List<Car> {
    val userInput = getCarNamesByUser()
    return try {
        generateCars(userInput)
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message)
        getCarNamesInput()
    }
}

fun generateCars(userInput: String?): List<Car> {
    val carNames = separateCarNames(userInput)
    validateCarNames(carNames)
    carNames.forEach { carName ->
        validateCarName(carName)
    }
    return carNames
        .map { name -> Car(name) }
        .toList()
}

private fun separateCarNames(userInput: String?): List<String> {
    return userInput!!.split(",")
}
