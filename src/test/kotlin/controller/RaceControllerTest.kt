package controller

import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import view.InputView
import view.OutputView
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream
import java.util.Random

class RaceControllerTest {
    private lateinit var outputStream: OutputStream

    @BeforeEach
    fun init() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun printOutput() {
        System.setOut(System.out)
        println(output())
    }

    private fun output(): String {
        return outputStream.toString().trim()
    }

    private val hwanCar = Car("hwan", 2)
    private val siaCar = Car("sia", 4)
    private val cars: List<Car> = listOf(hwanCar, siaCar)

    private val inOutController = ViewController(InputView(), OutputView())
    private val raceController = RaceController(3, cars, inOutController)

    @Test
    fun `자동차가 1칸 이동하면 현재 위치가 1 늘어난다`() {
        val random = Random(1234)
        val position = cars[0].currentPosition
        cars[0].moveCar(random)
        assertEquals(position + 1, cars[0].currentPosition)
    }

    @Test
    fun `가장 많이 움직인 자동차가 우승한다`() {
        val winnerList = raceController.getFinalResult()
        inOutController.printFinalResult(winnerList)

        assertThat(output()).isEqualTo("최종 우승자 : sia")
    }

    @Test
    fun `랜덤으로 가장 많이 전진한 자동차를 최종 우승자로 출력한다`() {
        val raceController = RaceController(4, cars, inOutController)
        raceController.startRacing()
        val winnerList = raceController.getFinalResult()
        inOutController.printFinalResult(winnerList)
        assertThat(output()).contains("최종 우승자 : ${winnerList.joinToString(", ") { it.name }}")
    }
}
