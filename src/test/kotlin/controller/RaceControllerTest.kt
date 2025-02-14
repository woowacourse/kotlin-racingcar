package controller

import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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

    fun output(): String {
        return outputStream.toString().trim()
    }

    val cars: MutableList<Car> = mutableListOf(Car("hwan", 2), Car("sia", 4))
    val inOutController = ViewController(OutputView())
    val raceController = RaceController(3, cars, inOutController)

    @Test
    fun `랜덤 숫자가 4 이상일 때 전진한다`() {
        val random = Random(1234)
        val position = cars[0].currentPosition
        cars[0].moveCar(random)
        assertEquals(position + 1, cars[0].currentPosition)
    }

    @Test
    fun `가장 많이 움직인 자동차가 우승한다`() {
        val winnerList = raceController.comparePosition()
        inOutController.printFinalResult(winnerList)

        assertThat(output()).isEqualTo("최종 우승자 : sia")
    }

    @Test
    fun `전체 로직 점검`() {
        val raceController = RaceController(4, cars, inOutController)
        raceController.fullRace()
        val winnerList = raceController.getFinalResult()
        inOutController.printFinalResult(winnerList)
        assertThat(output()).contains("최종 우승자 : ${winnerList.joinToString(", ") { it.name }}")
    }
}
