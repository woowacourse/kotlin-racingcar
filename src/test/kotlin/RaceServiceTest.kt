package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Messages

class RaceServiceTest {
    private lateinit var inputValidator: InputValidator
    private lateinit var raceService: RaceService
    private lateinit var random: RandomGenerator
    private lateinit var inputView: InputView
    private lateinit var outputView: OutputView

    class TestOutputView : OutputView {
        override val messages: MutableList<String> = mutableListOf()

        override fun showMessage(
            message: String,
            endWithNewLine: Boolean,
        ) {
            messages.add(message)
        }

        override fun showBlankLine() {
            messages.add("\n")
        }
    }

    class TestInputView(
        private val fakeInputs: List<String>,
    ) : InputView {
        private var currentIndex = 0

        override fun readInput(): String {
            require(currentIndex < fakeInputs.size) { "더 이상 입력이 없습니다" }
            return fakeInputs[currentIndex++]
        }
    }

    class TestRandom : RandomGenerator {
        private var fixedValue = 4

        override fun nextInt(
            from: Int,
            until: Int,
        ): Int = fixedValue
    }

    @BeforeEach
    fun setUp() {
        inputValidator = InputValidator()
        random = TestRandom()
        outputView = TestOutputView()
    }

    @Test
    @DisplayName("자동차 초기화 테스트")
    fun initCarsTest() {
        inputView = TestInputView(listOf("메다,밀러"))
        raceService = RaceService(random, outputView, inputView, inputValidator)

        assertDoesNotThrow {
            raceService.carsInitializer()
        }
        assertThat(outputView.messages).contains(Messages.USERINFO_INPUT_CAR_NAME.message)
    }

    @Test
    @DisplayName("중복 자동차 이름으로 초기화 테스트")
    fun initDuplicateNamesCarsTest() {
        inputView = TestInputView(listOf("메다,메다"))
        raceService = RaceService(random, outputView, inputView, inputValidator)

        assertThrows<IllegalArgumentException> {
            raceService.carsInitializer()
        }
    }

    @Test
    @DisplayName("레이스 진행 테스트")
    fun raceTest() {
        inputView = TestInputView(listOf("메다", "5"))
        raceService = RaceService(random, outputView, inputView, inputValidator)

        assertDoesNotThrow {
            raceService.carsInitializer()
            raceService.raceCountInitializer()
            raceService.doWholeRace()
        }

        assertThat(outputView.messages).contains("메다 : -----")
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    fun showWinnerTest() {
        inputView = TestInputView(listOf("메다,밀러", "10"))
        raceService = RaceService(random, outputView, inputView, inputValidator)

        assertDoesNotThrow {
            raceService.carsInitializer()
            raceService.raceCountInitializer()
            raceService.doWholeRace()
            raceService.showCarNamesByWinnerFormat()
        }
        val lastMessage = outputView.messages.last()
        assertThat(lastMessage).isEqualTo("최종 우승자 : 메다, 밀러")
    }
}
