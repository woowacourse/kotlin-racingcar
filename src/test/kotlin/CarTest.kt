import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car

@DisplayName("자동차의 ")
class CarTest {

    @DisplayName("디폴트 위치는 0이다")
    @Test
    fun 생성자_위치_명시하지_않으면_초기위치_0이다() {
        assertThat(Car("test").position).isEqualTo(0)
    }

    @ParameterizedTest(name = "이름이 {0}면 생성 불가능")
    @ValueSource(strings = ["", "applej", "한글로여섯자", "***%^$", " "])
    fun 이름길이가_1미만_5초과면_예외_발생(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }.shouldHaveMessage("이름의 길이는 1 이상 5 이하입니다")
    }

    @ParameterizedTest(name = "이름이 {0}면 생성 가능")
    @ValueSource(strings = ["a", "apple", "한글다섯자", "&"])
    fun 이름길이가_1이상_5이하면_정상_생성(name: String) {
        assertDoesNotThrow { Car(name) }
    }

    @ParameterizedTest(name = "위치가 {0}면 생성 불가능")
    @ValueSource(ints = [-1, -3])
    fun 위치가_음수면_예외_발생(position: Int) {
        assertThrows<IllegalArgumentException> {
            Car("test", position)
        }.message shouldBe "위치값은 0 이상이어야 합니다"
    }

    @ParameterizedTest(name = "위치가 {0}면 생성 가능")
    @ValueSource(ints = [0, 1, 100, 1000000])
    fun 위치가_양수면_정상_생성(position: Int) {
        assertDoesNotThrow { Car("test", position) }
    }

    @ParameterizedTest(name = "이동 숫자가 {0}이 들어오면 전진한다.")
    @ValueSource(ints = [4, 5, 8, 9])
    fun 이동_숫자가_4이상_9이하면_전진(number: Int) {
        val car = Car("Move")
        val previous: Int = car.position

        car.move(number)

        assertThat(car.position).isEqualTo(previous + 1)
    }

    @ParameterizedTest(name = "이동 숫자가 들어온 횟수만큼 전진한다.")
    @ValueSource(ints = [2, 3, 4, 100])
    fun 이동_숫자가_들어온_횟수만큼_전진(times: Int) {
        val car = Car("Move")
        val previous: Int = car.position

        for (i in 1..times) {
            car.move(4)
        }

        assertThat(car.position).isEqualTo(previous + times)
    }

    @ParameterizedTest(name = "이동 숫자가 {0}이 들어오면 정지한다.")
    @ValueSource(ints = [-1, 0, 2, 3, 10])
    fun 이동_숫자가_4미만_9초과면_정지(number: Int) {
        val car = Car("Stop")
        val previous: Int = car.position

        car.move(number)

        assertThat(car.position).isEqualTo(previous)
    }
}
