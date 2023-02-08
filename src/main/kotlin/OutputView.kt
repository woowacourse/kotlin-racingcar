import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class OutputView {
    private val br = BufferedReader(InputStreamReader(System.`in`))
    private val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    fun printResult(cars: List<Car>) {
        cars.forEach { car ->
            bw.write(car.getCar().first + " : " + "-".repeat(car.getCar().second))
        }
    }
}
