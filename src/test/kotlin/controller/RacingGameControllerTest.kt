package controller

import domain.Car
import domain.GameResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import view.InputView
import view.OutputView
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

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

    private val raceController = RacingGameController(InputView(), OutputView())

    @Test
    fun `현재 위치가 가장 큰 자동차가 우승한다`() {
        val gameResult = GameResult(cars)
        val winnerList = gameResult.getFinalResult()
        raceController.printFinalResult(winnerList)

        assertThat(output()).isEqualTo("최종 우승자 : sia")
    }
}
