package racingcar

import io.kotest.matchers.throwable.haveMessage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @DisplayName("생성 시 공백이 존재하면 에러가 발생한다.")
    @Test
    fun nameSpaceException() {
        assertThrows<IllegalArgumentException> {
            Car(" huni")
            haveMessage("[ERROR] 이름에 공백이 존재합니다.")
        }
    }

    @DisplayName("이름을 입력하지 않은 경우 에러가 발생한다")
    @Test
    fun nameNotInsert() {
        assertThrows<IllegalArgumentException> {
            Car("")
            haveMessage("[ERROR] 이름을 입력하지 않았습니다.")
        }
    }
}
