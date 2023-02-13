package domainTest

import controller.CarRacingGameController
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarRacingGameControllerTest {
    private lateinit var carRacingGameController: CarRacingGameController

    @BeforeEach
    fun setUp() {
        carRacingGameController = CarRacingGameController()
    }

    @ParameterizedTest
    @ValueSource(strings = ["30", "10", "5"])
    fun `자연수 형태의 시도 횟수를 입력한 경우`(inputNumberOfTry: String) {
        assertDoesNotThrow {
            carRacingGameController.validateNumericNumberOfTry(inputNumberOfTry)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "세번", "*"])
    fun `숫자 이외의 것을 입력한 경우`(inputNumberOfTry: String) {
        assertThrows<IllegalArgumentException> {
            carRacingGameController.validateNumericNumberOfTry(inputNumberOfTry)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-3", "4.5"])
    fun `자연수가 아닌 음수, 실수를 입력한 경우`(inputNumberOfTry: String) {
        assertThrows<IllegalArgumentException> {
            carRacingGameController.validateNumericNumberOfTry(inputNumberOfTry)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["우기,제임스,스캇,써니", "우기, abc초코,우 아 한"])
    fun `이름과 이름 사이에만 ,를 적절하게 사용한 경우`(inputCarNames: String) {
        assertDoesNotThrow {
            carRacingGameController.validateSuccessiveTokenizer(inputCarNames)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [",,우기,,,", "제임스,우기,,"])
    fun `,를 연속으로 입력한 경우`(inputCarNames: String) {
        assertThrows<IllegalArgumentException> {
            carRacingGameController.validateSuccessiveTokenizer(inputCarNames)
        }
    }
}
