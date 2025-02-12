import Constants.CONDITION_CAR_MIN_COUNT
import Constants.CONDITION_MOVE_THRESHOLD
import Constants.CONDITION_RANDOM_MAX
import Constants.CONDITION_RANDOM_MIN
import Constants.DELIMITER_WINNER_OUTPUT
import Constants.INDICATOR_CAR_POSITION
import Messages.MESSAGE_INPUT_RACE_COUNT
import Messages.MESSAGE_OUTPUT_RACE_RESULT
import Messages.MESSAGE_OUTPUT_WINNER
import java.io.BufferedReader
import java.io.InputStreamReader

object Messages {
    const val MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    const val MESSAGE_INPUT_RACE_COUNT = "시도할 횟수는 몇 회인가요?"
    const val MESSAGE_OUTPUT_RACE_RESULT = "실행 결과"
    const val MESSAGE_OUTPUT_WINNER = "최종 우승자: "
}

object Constants {
    const val DELIMITER_CAR_INPUT = ","
    const val INDICATOR_CAR_POSITION = "-"
    const val DELIMITER_WINNER_OUTPUT = ", "
    const val CONDITION_CAR_MAX_LENGTH = 5
    const val CONDITION_CAR_MIN_COUNT = 1
    const val CONDITION_RANDOM_MIN = 0
    const val CONDITION_RANDOM_MAX = 9
    const val CONDITION_MOVE_THRESHOLD = 4
}

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
        println(MESSAGE_INPUT_RACE_COUNT)
        val count = br.readLine().toIntOrNull() ?: throw IllegalArgumentException()
        if (count < CONDITION_CAR_MIN_COUNT) throw IllegalArgumentException()
        println()
        return count
    }

    fun printRound(car: Car) {
        println("${car.name} : ${INDICATOR_CAR_POSITION.repeat(car.position)}")
    }

    fun moveCars(cars: List<Car>) {
        cars.forEach { car ->
            val number = (CONDITION_RANDOM_MIN..CONDITION_RANDOM_MAX).random()
            if (number >= CONDITION_MOVE_THRESHOLD) car.position++
            printRound(car)
        }
    }

    fun race(count: Int, cars: List<Car>) {
        println(MESSAGE_OUTPUT_RACE_RESULT)
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

        println(MESSAGE_OUTPUT_WINNER + winner.joinToString(DELIMITER_WINNER_OUTPUT))
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