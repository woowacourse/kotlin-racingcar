package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
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

//    @Test
//    @DisplayName("자동차 이름은 ‘,’로 분할하여 name 프로퍼티에 저장한다")
//    fun t1() {
//        val input = "a,b,c"
//        val inputs = listOf("a", "b", "c")
//
//        InputValidator().getValidatedCarNames(input).forEachIndexed { idx, car ->
//            assertThat(car.name).isEqualTo(inputs[idx])
//        }
//    }
//
//    @Test
//    @DisplayName("자동차 이름이 6자 이상인 경우 예외가 발생한다.")
//    fun t1_2() {
//        val input = "a,b,123456,c"
//
//        assertThrows<IllegalArgumentException> { InputValidator().getValidatedCarNames(input) }
//    }
//
//    @Test
//    @DisplayName("자동차 이름이 비어있는 경우 예외가 발생한다.")
//    fun t1_3() {
//        val input = "a,,b,c"
//
//        assertThrows<IllegalArgumentException> { InputValidator().getValidatedCarNames(input) }
//    }
//
//    @Test
//    @DisplayName("자동차 이름에 특수문자가 존재할 경우 예외가 발생한다.")
//    fun t1_4() {
//        val input = "@밀러,@메다"
//
//        assertThrows<IllegalArgumentException> { InputValidator().getValidatedCarNames(input) }
//    }
//
//    @Test
//    @DisplayName("자동차 이름에 중복이 존재할 경우 예외가 발생한다.")
//    fun t1_5() {
//        val input = "밀러,밀러,메다"
//
//        assertThrows<IllegalArgumentException> { InputValidator().getValidatedCarNames(input) }
//    }
//
//    @Test
//    @DisplayName("trim을 적용한 자동차 이름에 중복이 존재할 경우 예외가 발생한다.")
//    fun t1_6() {
//        val input = " 밀러 ,밀러     ,메다"
//
//        assertThrows<IllegalArgumentException> { InputValidator().getValidatedCarNames(input) }
//    }
//
//    @Test
//    @DisplayName("이동한 거리는 distance 프로퍼티에 저장되며 객체 생성시 0으로 초기화 한다")
//    fun t2() {
//        val input = "a,b,c"
//        InputValidator().getValidatedCarNames(input).forEach { car ->
//            assertThat(car.distance).isEqualTo(0)
//        }
//    }

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

//    @Test
//    @DisplayName("cars리스트에 저장된 car객체들의 distance중 최대값을 가지는 이름들을 가져온다")
//    fun t4() {
//        val car1 = Car("a", 1)
//        val car2 = Car("b")
//        val cars = listOf(car1, car2)
//        val raceService = RaceService()
//
//        assertThat(raceService.getWinner(cars)).contains("최종 우승자 : a")
//    }

    @Test
    @DisplayName("전체 기능 테스트")
    fun t5() {
        setInput("pobi,woni,jun \n5")
        val output = setOutput()

        Application().run()
        assertThat(output.toString().normalize()).contains(
            """
            경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
            시도할 횟수는 몇 회인가요?

            실행 결과
            pobi : 
            """.trimIndent().normalize(),
        )
        assertThat(output.toString().normalize()).contains(
            """
            
            최종 우승자 : 
            """.trimIndent().normalize(),
        )
    }

    @Test
    @DisplayName("랜덤 값 추출 테스트, 확률이 60%~60.01% 사이여야 한다")
    fun t6() {
        val random = Random(RANDOM_SEED)
        var count = 0
        val osName = System.getProperty("os.name")
        assertThat(osName).contains("MAc")
        repeat(100000000) { if (random.nextInt(0, 10) >= 4) count++ }
        assertThat(count)
            .isGreaterThan(60000000)
            .isLessThan(60010000)
    }

    private fun String.normalize(): String =
        this
            .replace("\r\n", "\n") // 윈도우 -> 맥
            .replace("\r", "\n") // 구형 맥
            .trimEnd()
}
