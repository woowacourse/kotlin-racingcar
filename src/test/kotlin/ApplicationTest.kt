import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ApplicationTest {
    @Test
    fun `자동차는 전진한다`() {
        val car = Car("Test")
        car.move()
        assertThat(car.distance).isEqualTo(1)
    }

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        assertThat(checkCarNameValid("5자 이상의 자동차 이름")).isFalse()
    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        val userInputExample = "자동차,이름은,쉼표로,구분한다"
        val cars = userInputExample.toCars()
        assertThat(cars.map { car: Car -> car.name }).isEqualTo(listOf("자동차", "이름은", "쉼표로", "구분한다"))
    }

    @ValueSource(strings = ["", "0", "-1", "1.1", "asd", "${Int.MAX_VALUE + 1}"])
    @ParameterizedTest
    fun `시도횟수는 1 이상의 숫자여야 한다`(round: String) {
        assertThat(checkRoundValid(round)).isEqualTo(0)
    }

    @ValueSource(ints = [0, 3])
    @ParameterizedTest
    fun `0에서 3이면 전진하지 않는다`(number: Int) {
        val race = Racecourse(listOf(Car("name")), 1)
        assertThat(race.isMovable(number)).isFalse()
    }

    @ValueSource(ints = [0, 3])
    @ParameterizedTest
    fun `4에서 9이면 전진한다`(number: Int) {
        val race = Racecourse(listOf(Car("name")), 1)
        assertThat(race.isMovable(number)).isTrue()
    }

    @Test
    fun `자동차 경주 게임을 완료한 후 가장 큰 distance를 가진 객체가 우승한다`() {
        val cars: List<Car> =
            listOf(
                Car(name = "a", initialDistance = 5),
                Car(name = "b", initialDistance = 0),
                Car(name = "c", initialDistance = 0),
            )
        val racecourse = Racecourse(cars, 0)
        val expectedWinners = listOf(Car(name = "a", initialDistance = 5))
        assertThat(racecourse.winners).isEqualTo(expectedWinners)
    }
}
