import dto.TryCount
import model.CarManger
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputTest {
    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        assertThatThrownBy {
            CarManger("pobi, jason1, haki")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차 이름은 중복될 수 없다`() {
        assertThatThrownBy {
            CarManger("가가,나나,나나,다다")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `시도 횟수는 0 이하일 수 없다`() {
        assertThatThrownBy {
            TryCount("-1").tryCountNumber
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력받은 시도 횟수는 숫자 이외의 문자일 수 없다`() {
        assertThatThrownBy {
            TryCount("a").tryCountNumber
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차 이름을 아무것도 입력받지 않을 수 없다`() {
        assertThatThrownBy {
            TryCount("").tryCountNumber
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
