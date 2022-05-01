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
    // validateCarNames(carNames)
    // carNames.forEach { carName ->
    //     validateCarName(carName)
    // }
    return carNames
        .map { name -> Car(name) }
        .toList()
}

private fun separateCarNames(userInput: String?): List<String> {
    return userInput!!.split(",")
}
