import java.io.BufferedReader
import java.io.InputStreamReader

class Racingcar {

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carsInput = br.readLine().split(",").map { it.trim() }

        val cars = mutableSetOf<Car>()
        carsInput.map { cars.add(Car(it, 0)) }

    }

}