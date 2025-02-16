package racingcar

class RaceService(
//    private val inputValidator: InputValidator,
) {
//    private val cars = mutableListOf<Car>()
//    private var raceCount = 0
//
//    fun carsInitializer() {
//        cars.clear()
//        outputView.showMessage(Messages.USERINFO_INPUT_CAR_NAME.message, true)
//        val carNamesUserInput = inputView.readInput()
//        cars += getCarsByUserInput(carNamesUserInput)
//    }
//
//    private fun getCarsByUserInput(userInput: String): List<Car> {
//        val carNames = userInput.split(",").map { it.trim() }
//        val cars = carNames.map { Car(it, inputValidator) }
//        inputValidator.duplicateCarNameCheck(cars)
//        return cars
//    }
//
//    fun raceCountInitializer() {
//        outputView.showMessage(Messages.USERINFO_INPUT_RACE_COUNT.message, true)
//        val raceCountUserInput = inputView.readInput()
//        inputValidator.validRaceCountChecker(raceCountUserInput)
//        raceCount = raceCountUserInput.toInt()
//    }
//
//    private fun filterWinCars(): List<Car> = cars.filter { it.distance == cars.maxOf { car -> car.distance } }
//
//    fun showCarNamesByWinnerFormat() =
//        outputView.showMessage(
//            Messages.WINNER_NAMES_ANNOUNCE.formattedMessage(
//                filterWinCars().joinToString(", ") { it.name },
//            ),
//            true,
//        )
//
//    fun showRaceResultHeader() {
//        outputView.showBlankLine()
//        outputView.showMessage(Messages.RACE_RESULT.message, true)
//    }
//
//    fun doWholeRace() {
//        repeat(raceCount) {
//            doSingleRace(cars)
//            outputView.showBlankLine()
//        }
//    }
//
//    private fun doSingleRace(cars: List<Car>) {
//        cars.forEach { car ->
//            car.moveByValue(random.nextInt(0, 10))
//            outputView.showMessage(car.toString(), true)
//        }
//    }
}
