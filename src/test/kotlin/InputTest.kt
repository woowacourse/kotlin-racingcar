import controller.InOutController
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import view.InOutView

class InputTest {
    val inOutController = InOutController(InOutView())

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        assertThatThrownBy {
            inOutController.splitToComma("pobi, jason1, haki")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `쉼표 앞 뒤에 공백이 있을 때 공백을 글자 수로 취급하지 않는다`() {
        assertDoesNotThrow {
            inOutController.splitToComma("pobi, jason, haki")
        }
    }

    @Test
    fun `자동차 이름은 중복될 수 없다`() {
        assertThatThrownBy {
            inOutController.splitToComma("가가,가가,나나,다다")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `시도 횟수는 0 이하일 수 없다`() {
        assertThatThrownBy {
            inOutController.parseInt("-1")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력받은 시도 횟수는 숫자 이외의 문자일 수 없다`() {
        assertThatThrownBy {
            inOutController.parseInt("a")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차 이름을 아무것도 입력받지 않을 수 없다`() {
        assertThatThrownBy {
            inOutController.splitToComma("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
