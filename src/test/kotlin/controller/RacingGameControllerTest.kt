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

class RacingGameControllerTest {
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

    private val inOutController = RacingViewController(InputView(), OutputView())
    private val raceController = RacingGameController()

    @Test
    fun `자동차가 1칸 이동하면 현재 위치가 1 늘어난다`() {
        val random = Random(1234)
        val position = hwanCar.currentPosition
        hwanCar.moveCar(random)
        assertEquals(position + 1, hwanCar.currentPosition)
    }

    @Test
    fun `랜덤 숫자가 4 미만인 경우, 자동차의 위치는 바뀌지 않는다`() {
        val random = Random(123)
        val position = siaCar.currentPosition
        siaCar.moveCar(random)
        assertEquals(position, siaCar.currentPosition)
    }

    @Test
    fun `가장 많이 움직인 자동차가 우승한다`() {
        val winnerList = raceController.getFinalResult(cars)
        inOutController.printFinalResult(winnerList)

        assertThat(output()).isEqualTo("최종 우승자 : sia")
    }
}
