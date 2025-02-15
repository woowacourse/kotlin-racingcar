package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import utils.MoveConditionGenerator.getMoveConditionByNumber

class CarTest {
    @ParameterizedTest
    @ValueSource(
        ints = [4, 5, 6, 7, 8, 9],
    )
    fun `무작위 값이 4 이상인 경우, 자동차는 전진한다`(num: Int) {
        val car = Car("테스트", 0)
        val condition = getMoveConditionByNumber(num)
        car.moveOrStop(condition)
        assertThat(car.position == 1).isTrue()
    }

    @ParameterizedTest
    @ValueSource(
        ints = [0, 1, 2, 3],
    )
    fun `무작위 값이 4 미만인 경우, 자동차는 전진하지 않는다`(num: Int) {
        val car = Car("테스트", 0)
        val condition = getMoveConditionByNumber(num)
        car.moveOrStop(condition)
        assertThat(car.position == 0).isTrue()
    }
}
