import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class JudgeTest {
    private val judge = Judge()

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤 숫자가 4 미만인 경우 false 를 반환한다`(randomNumber: Int) {
        Assertions.assertFalse(judge.isCarAbleToMove(randomNumber))
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자가 4 이상인 경우 true 를 반환한다`(randomNumber: Int) {
        Assertions.assertTrue(judge.isCarAbleToMove(randomNumber))
    }
}
