import util.Constants
import util.Messages
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    fun readCars(): List<String> {
        println(Messages.MESSAGE_INPUT_CAR_NAMES)
        val carsInput = br.readLine().split(Constants.DELIMITER_CAR_INPUT).map { it.trim() }
        carsInput.forEach {
            if (it.isEmpty() || it.length > Constants.CONDITION_CAR_MAX_LENGTH) {
                throw IllegalArgumentException()
            }
        }

        if (carsInput.size > carsInput.toSet().size) {
            throw IllegalArgumentException()
        }

        return carsInput
    }

    fun generateCarList(carsInput: List<String>): MutableList<Car> {
        val cars = mutableListOf<Car>()
        carsInput.map { cars.add(Car(it, 0)) }
        return cars
    }

    fun readCount(): Int {
        println(Messages.MESSAGE_INPUT_RACE_COUNT)
        val count = br.readLine().toIntOrNull() ?: throw IllegalArgumentException()
        if (count < Constants.CONDITION_CAR_MIN_COUNT) throw IllegalArgumentException()
        println()
        return count
    }

    fun printRound(car: Car) {
        println("${car.name} : ${Constants.INDICATOR_CAR_POSITION.repeat(car.position)}")
    }

    fun moveCars(cars: List<Car>) {
        cars.forEach { car ->
            val number = (Constants.CONDITION_RANDOM_MIN..Constants.CONDITION_RANDOM_MAX).random()
            if (number >= Constants.CONDITION_MOVE_THRESHOLD) car.position++
            printRound(car)
        }
    }

    fun race(count: Int, cars: List<Car>) {
        println(Messages.MESSAGE_OUTPUT_RACE_RESULT)
        repeat(count) {
            moveCars(cars)
            println()
        }
    }

    fun printWinner(cars: List<Car>) {
        val winner = mutableListOf<String>()
        cars.forEach { car ->
            if (car.position == cars.maxOf { it.position }) {
                winner.add(car.name)
            }
        }

        println(Messages.MESSAGE_OUTPUT_WINNER + winner.joinToString(Constants.DELIMITER_WINNER_OUTPUT))
    }

    fun start() {
        val carInput = readCars()
        val cars = generateCarList(carInput)
        val count = readCount()
        race(count, cars)
        printWinner(cars)
    }

    start()
}