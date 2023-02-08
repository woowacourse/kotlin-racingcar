class RaceGame {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val randomGenerator = RandomGenerator()
    private var maxValue = -1

    private fun tryMove(cars: List<Car>) {
        for (car in cars) {
            car.move(randomGenerator.getRandomNumber())
            outputView.outputResult(car)
            if (car.getInfo().second > maxValue) maxValue = car.getInfo().second
        }
    }

    private fun equalMaxValue(cars: List<Car>): List<String> {
        val maxEqualCars = cars.filter {
            it.getInfo().second == maxValue
        }.toList()
        val names = mutableListOf<String>()
        for (car in maxEqualCars) {
            names.add(car.getInfo().first)
        }
        return names
    }

    fun run() {
        outputView.outputCarNames()
        val cars = inputView.inputCarNames()
        val tryNumber = executeInputTryNumber()
        outputView.outputResults()
        for (i in 1..tryNumber) {
            tryMove(cars)
            println()
        }
        outputView.outputWinners(equalMaxValue(cars))
    }

    private fun executeInputTryNumber(): Int {
        outputView.outputTryNumber()
        return getInputTryNumber(inputView.inputTryNumber())
    }

    private fun getInputTryNumber(number: String?): Int {
        try {
            Validator().checkTryNumber(number)
            return number!!.toInt()
        } catch (e: IllegalArgumentException) {
            outputView.outputErrorMessage(e.message!!)
            return executeInputTryNumber()
        }
    }
}
