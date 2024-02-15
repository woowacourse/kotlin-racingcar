package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {

    private lateinit var outContent: ByteArrayOutputStream

    @BeforeEach
    fun setup() {
        outContent = ByteArrayOutputStream()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3, 10])
    fun `현재 위치가 0일 때, 현재 위치 출력 테스트`(nums: Int) {
        val car = Car("carName", nums)
        System.setOut(PrintStream(outContent))
        OutputView.printCurrentPosition(car.name, car.position)

        val output = outContent.toString()
        assertThat(output).contains(
            "carName : ", "-".repeat(nums)
        )
    }
}