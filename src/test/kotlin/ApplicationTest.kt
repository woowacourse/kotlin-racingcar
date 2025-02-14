import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.Car
import racingcar.Racecourse

class ApplicationTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4 이상의 값이라면 자동차는 한칸 전진한다`(number: Int) {
        val car: Car = Car.createCars("Test").first()
        car.move(number)
        assertThat(car.distance == 1).isTrue
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4 미만의 값이라면 자동차는 정지한다`(number: Int) {
        val car: Car = Car.createCars("Test").first()
        car.move(number)
        assertThat(car.distance == 0).isTrue
    }

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        assertThatThrownBy { Car.createCars("5자 이상의 자동차 이름") }.hasMessage("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.")
    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        assertThat(Car.createCars("자동차, 이름은, 쉼표로, 구분한다").map { car: Car -> car.name }).isEqualTo(
            listOf(
                "자동차",
                "이름은",
                "쉼표로",
                "구분한다",
            ),
        )
    }

    @Test
    fun `시도횟수는 1 이상의 숫자여야 한다`() {
        assertThatThrownBy({ parseToRound("0") }).hasMessage("시도할 횟수는 1 이상의 자연수여야 합니다. 다시 입력해주세요.")
        assertThatThrownBy({ parseToRound("-1") }).hasMessage("시도할 횟수는 1 이상의 자연수여야 합니다. 다시 입력해주세요.")
        assertThatThrownBy({ parseToRound("One") }).hasMessage("시도할 횟수는 1 이상의 자연수여야 합니다. 다시 입력해주세요.")
    }

    @Test
    fun `전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다`() {
        (0..3).forEach { random -> assertThat(Car.isMovable(random)).isFalse() }
        (4..9).forEach { random -> assertThat(Car.isMovable(random)).isTrue() }
    }

    @Test
    fun `자동차 경주 게임의 우승자는 가장 멀리 간 사람이다`() {
        val cars: List<Car> = Car.createCars("a,b,c")
        cars.first().move(9)
        val racecourse = Racecourse(cars, 0)
        assertThat(racecourse.winners).isEqualTo(listOf(cars.first()))
    }
}
