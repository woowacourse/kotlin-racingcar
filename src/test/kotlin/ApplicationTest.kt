package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.Configure.Companion.RANDOM_SEED
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream
import kotlin.random.Random

class ApplicationTest {
    private fun setInput(input: String) {
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
    }

    private fun setOutput(): ByteArrayOutputStream {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val printStream = PrintStream(byteArrayOutputStream)
        System.setOut(printStream)
        return byteArrayOutputStream
    }

    @Test
    @DisplayName("자동차 이름은 ‘,’로 분할하여 name 프로퍼티에 저장한다")
    fun t1() {
        val input = "a,b,c"
        val inputs = listOf("a", "b", "c")

        InputValidator().carNamesValidate(input).forEachIndexed { idx, car ->
            assertThat(car.name).isEqualTo(inputs[idx])
        }
    }

    @Test
    @DisplayName("이동한 거리는 distance 프로퍼티에 저장되며 객체 생성시 0으로 초기화 한다")
    fun t2() {
        val input = "a,b,c"
        InputValidator().carNamesValidate(input).forEach { car ->
            assertThat(car.distance).isEqualTo(0)
        }
    }

    @Test
    @DisplayName("Int 자료형으로 입력 가능한 1이상의 자연수만 허용한다")
    fun t3() {
        setInput("a\n0")
        assertThrows<IllegalArgumentException> { Application().run() }
    }

    @Test
    @DisplayName("Int 자료형으로 입력 가능한 1이상의 자연수만 허용한다")
    fun t3_1() {
        setInput("a\n1")
        assertDoesNotThrow { Application().run() }
    }

    @Test
    @DisplayName("cars리스트에 저장된 car객체들의 distance중 최대값을 가지는 이름들을 가져온다")
    fun t4() {
        val car1 = Car("a", 1)
        val car2 = Car("b")
        val cars = listOf(car1, car2)
        val application = Application(cars = cars, raceCount = 0)
        val output = setOutput()

        application.run()
        assertThat(output.toString()).contains("최종 우승자 : a")
    }

    @Test
    @DisplayName("전체 기능 테스트")
    fun t5() {
        setInput("pobi,woni,jun \n5")
        val output = setOutput()

        Application().run()
        assertThat(output.toString()).contains(
            """
            경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
            시도할 횟수는 몇 회인가요?

            실행 결과
            pobi : 
            """.trimIndent(),
        )
    }

    @Test
    @DisplayName("랜덤 값 추출 테스트, 확률이 60%~60.01% 사이여야 한다")
    fun t6() {
        val random = Random(RANDOM_SEED)
        var count = 0
        repeat(100000000) { if (random.nextInt(0, 10) >= 4) count++ }
        assertThat(count)
            .isGreaterThan(60000000)
            .isLessThan(60010000)
    }
}
