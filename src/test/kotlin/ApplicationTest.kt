import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.Car
import racingcar.Racecourse

class ApplicationTest {
    @Test
    fun `주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다`() {
        val cars: List<Car> = Car.createCars("Test1, Test2, Test3")
        val round: Int = (1..10_000).random()
        val expectedDistance: IntRange = 0..round
        repeat(round) { cars.forEach(Car::move) }
        assertThat(cars).allSatisfy { car: Car -> car.distance in expectedDistance }
    }

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        assertThatThrownBy { Car.createCars("5자 이상의 자동차 이름") }.hasMessage("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.")
    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        val userInputExample = "자동차,이름은,쉼표로,구분한다"
        val cars = userInputExample.toCars()
        assertThat(cars.map { car: Car -> car.name }).isEqualTo(listOf("자동차", "이름은", "쉼표로", "구분한다"))
    }

    @Test
    fun `시도횟수는 1 이상의 숫자여야 한다`() {
        assertThat(checkRoundValid(null)).isFalse()
        assertThat(checkRoundValid("")).isFalse()
        assertThat(checkRoundValid("0")).isFalse()
        assertThat(checkRoundValid("-1")).isFalse()
        assertThat(checkRoundValid("1.1")).isFalse()
        assertThat(checkRoundValid("asd")).isFalse()
        assertThat(checkRoundValid("${Int.MAX_VALUE + 1}")).isFalse()
        assertThat(checkRoundValid("10")).isTrue()
    }

    @Test
    fun `전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다`() {
        (0..3).forEach { random -> assertThat(Car.isMovable(random)).isFalse() }
        (4..9).forEach { random -> assertThat(Car.isMovable(random)).isTrue() }
    }

    @Test
    fun `자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다`() {
        val cars: List<Car> =
            listOf(
                Car(name = "a", initialDistance = 5),
                Car(name = "b", initialDistance = 0),
                Car(name = "c", initialDistance = 0),
            )
        val racecourse = Racecourse(cars, 0)
        val expectedWinners: List<Car> = listOf(Car(name = "a", initialDistance = 5))
        assertThat(racecourse.winners).isEqualTo(expectedWinners)
    }
}
