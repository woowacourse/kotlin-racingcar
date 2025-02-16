import model.Car
import model.Game
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\t", "\n"])
    fun `자동차 이름이 공백일 경우 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> { Car(input.trim()) }
    }

    @Test
    fun `자동차 이름이 5자를 초과할 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { Car("123456") }
    }

    @Test
    fun `자동차 이름에 중복이 있을 경우 예외가 발생한다`() {
        val cars = listOf(Car("A"), Car("B"), Car("C"), Car("A"))
        assertThrows<IllegalArgumentException> { Game(cars, 1) }
    }

//    @ParameterizedTest
//    @ValueSource(strings = ["", "a", "1.23", "2147483648"])
//    fun `경주 횟수가 정수가 아닌 경우 예외를 발생한다`(count: String) {
//        assertThrows<IllegalArgumentException> { Validator.validateCount(count) }
//    }
//
//    @Test
//    fun `경주 횟수가 1보다 작은 경우 예외를 발생한다`() {
//        assertThrows<IllegalArgumentException> { Validator.validateCount("0") }
//    }
}
