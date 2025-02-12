import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    fun readCars(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carsInput = br.readLine().split(",").map { it.trim() }
        carsInput.forEach {
            if (it.isEmpty() || it.length > 5) {
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
        println("시도할 횟수는 몇 회인가요?")
        val count = br.readLine().toIntOrNull() ?: throw IllegalArgumentException()
        if (count <= 0) throw IllegalArgumentException()
        println()
        return count
    }

    fun printRound(car: Car) {
        println("${car.name} : ${"-".repeat(car.position)}")
    }

    fun moveCars(cars: List<Car>) {
        cars.forEach {
            val number = Random.nextInt(10)
            if (number >= 4) it.position++
            printRound(it)
        }
    }

    fun race(count: Int, cars: List<Car>) {
        println("실행 결과")
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

        println("최종 우승자: ${winner.joinToString(", ")}")
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