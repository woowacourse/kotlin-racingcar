
class OutputView {

    fun outputCarNames() {
        println(Constants.INPUT_CAR_NAME)
    }

    fun outputTryNumber() {
        println(Constants.INPUT_TRY_NUMBER)
    }

    fun outputResults(cars: List<Car>) {
        println(Constants.OUTPUT_RESULT)
        for (car in cars) {
            outputResult(car)
        }
    }

    fun outputResult(car: Car) {
        val carInfo = car.getInfo()
        print(carInfo.first + " : ")
        for (i in 1..carInfo.second) {
            print("-")
        }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(Constants.OUTPUT_WINNER + winners.joinToString(separator = ", "))
    }
}
