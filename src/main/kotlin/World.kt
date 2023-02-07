import java.util.Random

class World {
    val cars = mutableListOf<Car>()
    var attemptCount = 0
    val outputView = OutputView()
    val inputView = InputView()

    fun init() {
        outputView.printMessage(OutputView.MSG_INPUT_CAR_NAME)
        val names = inputView.carNames()
        for (name in names) {
            cars.add(Car(name))
        }
        outputView.printMessage(OutputView.MSG_INPUT_ATTEMPT_COUNT)
        attemptCount = inputView.attemptCount()
    }

    fun run() {
        for (i in 0 until cars.size) {
            processStep(cars[i])
        }
        outputView.printMessage(OutputView.MSG_STEP_RESULT)
        outputView.stepResult(cars)
    }

    fun quit() {
        outputView.winner(determineWinner())
    }

    fun determineWinner(): List<Car> {
        val sortedCars = cars.sortedWith { car, car2 -> if (car.compareTo(car2)) 1 else -1 }
        println(sortedCars)
        val winners = sortedCars.filter { it.compareTo(sortedCars[0]) }
        println(winners)
        return winners
    }

    fun processStep(car: Car) {
        val number = generateRandom()
        if (number >= 4) {
            car.forward()
        }
    }

    fun generateRandom(): Int {
        return Random().nextInt(10)
    }
}
