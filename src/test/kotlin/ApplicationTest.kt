import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest {
    @Test
    fun `주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다`() {
        val car = Car("Test")
        car.move()
        assertThat(car.distance).isIn(car.distance, car.distance + 1)
    }

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        val car = Car("5자 이상의 자동차 이름")
        assertThat(isCarNameValid(car)).isFalse()
    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        val userInputExample = "자동차,이름은,쉼표로,구분한다"
        val cars = userInputExample.toCars()
        assertThat(cars.map { car: Car -> car.name }).isEqualTo(listOf("자동차", "이름은", "쉼표로", "구분한다"))
    }

    @Test
    fun `전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다`() {
        (0..3).forEach { random -> assertThat(Car.isMovable(random)).isFalse() }
        (4..9).forEach { random -> assertThat(Car.isMovable(random)).isTrue() }
    }

    @Test
    fun `자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다`() {
    }
}
