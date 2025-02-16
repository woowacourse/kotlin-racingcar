package controller

import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import view.InView
import view.OutView
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

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

    val cars: MutableList<Car> = mutableListOf(Car("hwan"), Car("xia"))
    val outController = OutController(OutView())

    @Test
    fun `랜덤으로 움직인 자동차 중 가장 많이 움직인 자동차가 우승한다`() {
        val raceController = RaceController(4, cars, outController)
        raceController.fullRace()
        val winnerList = raceController.getFinalResult()
        outController.printFinalResult(winnerList)
        assertThat(output()).contains("최종 우승자 : ${winnerList.joinToString(", ") { it.name }}")
    }
}
