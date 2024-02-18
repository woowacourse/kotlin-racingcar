package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Cars

class CarsTest {
    @DisplayName("자동차를 입력하지 않았을 때")
    @Test
    fun inputNone() {
        assertThrows<IllegalArgumentException> {
            Cars(emptyList())
        }
    }

    @DisplayName("자동차 수가 두 대 미만일 때")
    @Test
    fun inputLessThanTwo() {
        val names = listOf("lisa")

        assertThrows<IllegalArgumentException> {
            Cars(names)
        }
    }

    @DisplayName("자동차 수가 20대 초과일 때")
    @Test
    fun inputGreaterThanTwenty() {
        val names =
            listOf(
                "crong", "lisa", "hena", "pobi", "poro", "lufy", "joro", "sang", "frank", "usop",
                "nami", "zzang", "huni", "chul", "yuri", "meang", "chae", "miri", "won", "shin", "bong", "siro",
            )

        assertThrows<IllegalArgumentException> {
            Cars(names)
        }
    }

    @DisplayName("중복된 자동차 이름이 있을 때")
    @Test
    fun inputDuplicatedName() {
        val names = listOf("crong", "crong")

        assertThrows<IllegalArgumentException> {
            Cars(names)
        }
    }
}
