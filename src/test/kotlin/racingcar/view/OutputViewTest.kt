package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {

    private lateinit var outContent: ByteArrayOutputStream

    @BeforeEach
    fun setup() {
        outContent = ByteArrayOutputStream()
    }

    @Test
    fun `현재 위치가 0일 때, 현재 위치 출력 테스트`() {
        val car = Car("km")
        System.setOut(PrintStream(outContent))
        OutputView.printCurrentPosition(car.name, car.position)

        val output = outContent.toString()
        assertThat(output).contains(
            "km : "
        )
    }


    @Test
    fun `현재 위치가 3일 때, 현재 위치 출력 테스트`() {
        val car = Car("km", 3)
        System.setOut(PrintStream(outContent))
        OutputView.printCurrentPosition(car.name, car.position)

        val output = outContent.toString()
        assertThat(output).contains(
            "km : ",
            "---"
        )
    }
}