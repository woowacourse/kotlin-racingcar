package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Cars

class CarsTest {
    @Test
    fun inputNone() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Cars(emptyList())
            }

        Assertions.assertThat(exception.message.equals(ERROR_REQUEST_INPUT))
    }

    @Test
    fun inputLessThanTwo() {
        val names = listOf("lisa")
        val exception =
            assertThrows<IllegalArgumentException> {
                Cars(names)
            }

        Assertions.assertThat(exception.message.equals(ERROR_CAR_LESS_THAN_TWO))
    }

    @Test
    fun inputGreaterThanTwenty() {
        val names =
            listOf(
                "crong", "lisa", "hena", "pobi", "poro", "lufy", "joro", "sang", "frank", "usop",
                "nami", "zzang", "huni", "chul", "yuri", "meang", "chae", "miri", "won", "shin", "bong", "siro",
            )
        val exception =
            assertThrows<IllegalArgumentException> {
                Cars(names)
            }

        Assertions.assertThat(exception.message.equals(ERROR_CAR_GREATER_THAN_TWENTY))
    }

    @Test
    fun inputDuplicatedName() {
        val names = listOf("crong", "crong")
        val exception =
            assertThrows<IllegalArgumentException> {
                Cars(names)
            }

        Assertions.assertThat(exception.message.equals(ERROR_NAME_DUPLICATION))
    }


    companion object {
        const val ERROR_REQUEST_INPUT = "[Error] 값을 입력해 주세요"
        const val ERROR_CAR_LESS_THAN_TWO = "[Error] 자동차 이름은 2대 이상 입력해 주세요."
        const val ERROR_CAR_GREATER_THAN_TWENTY = "[Error] 자동차 이름은 20대 이하로 입력해 주세요."
        const val ERROR_NAME_DUPLICATION = "[Error] 중복된 자동차 이름은 작성할 수 없습니다."
    }
}