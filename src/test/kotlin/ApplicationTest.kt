package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.Configure.Companion.RANDOM_SEED
import java.io.ByteArrayInputStream
import java.io.InputStream
import kotlin.random.Random

class ApplicationTest {
	@Test
	@DisplayName("자동차 이름은 ‘,’로 분할하여 name 프로퍼티에 저장한다")
	fun t1() {
		val input = "a,b,c"
		val inputs = listOf("a", "b", "c")

		InputValidator().carNamesValidate(input).forEachIndexed {idx, car ->
			assertThat(car.name).isEqualTo(inputs[idx])
		}
	}

	@Test
	@DisplayName("이동한 거리는 distance 프로퍼티에 저장되며 객체 생성시 0으로 초기화 한다")
	fun t2() {
		val input = "a,b,c"
		InputValidator().carNamesValidate(input).forEachIndexed {idx, car ->
			assertThat(car.distance).isEqualTo(0)
		}
	}

	@Test
	@DisplayName("값이 4 이상일 경우 distance를 1 증가한다")
	fun t3() {
		val random = Random(1)
		val car = Car("a", random)
		car.randomMove()
		if (random.nextInt(0, 10) >= 4) {
			assertThat(car.distance).isEqualTo(1)
		} else {
			assertThat(car.distance).isEqualTo(0)
		}
	}

	@Test
	@DisplayName("Int 자료형으로 입력 가능한 1이상의 자연수만 허용한다")
	fun t4() {
		val input = "a\n0" // 가상의 입력
		val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
		System.setIn(inputStream)

		assertThrows<IllegalArgumentException> {Application().run() }

	}

	@Test
	@DisplayName("Int 자료형으로 입력 가능한 1이상의 자연수만 허용한다")
	fun t4_1() {
		val input = "a\n1" // 가상의 입력
		val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
		System.setIn(inputStream)

		assertDoesNotThrow {  Application().run() }
	}

	@Test
	@DisplayName("cars리스트에 저장된 car객체들의 distance중 최대값을 가지는 이름들을 가져온다")
	fun t5() {
		val random = Random(RANDOM_SEED)
		val car = listOf(Car("a", random), Car("b", random))
		val application = Application(cars = car)
		application.run()


	}
}