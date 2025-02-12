import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

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

    val cars = mutableSetOf<Car>()
    carsInput.map { cars.add(Car(it, 0)) }

    println("시도할 횟수는 몇 회인가요?")
    val count = br.readLine().toInt()
    println()

    println("실행 결과")
    repeat(count) {
        cars.forEach {
            val number = Random.nextInt(10)
            if (number >= 4) it.position++
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }

    val winner = mutableListOf<String>()
    cars.forEach { car ->
        if (car.position == cars.maxOf { it.position }) {
            winner.add(car.name)
        }
    }

    println("최종 우승자: ${winner.joinToString(", ")}")
}