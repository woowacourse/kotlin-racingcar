package racingcar.utils

import racingcar.domain.KCar
import racingcar.ui.getCarNamesByUser
import racingcar.ui.printErrorMessage
import racingcar.validator.validateCarName
import racingcar.validator.validateCarNames

fun getCarNamesInput(): List<KCar> {
    val userInput = getCarNamesByUser()
    return try {
        generateCars(userInput)
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message)
        getCarNamesInput()
    }
}

fun generateCars(userInput: String?): List<KCar> {
    val carNames = separateCarNames(userInput)
    validateCarNames(carNames)
    carNames.forEach { carName ->
        validateCarName(carName)
    }
    return carNames
        .map { name -> KCar(name) }
        .toList()
}

private fun separateCarNames(userInput: String?): List<String> {
    return userInput!!.split(",")
}
