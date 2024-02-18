package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.ValidationUtil

class GameControllerTest {
    @Test
    fun `자동차 이름 입력은 1~5글자 이내이어야 합니다`() {
        assertDoesNotThrow{ValidationUtil.validateCarNames("hodu,abcde,jini")}
        assertThrows<IllegalArgumentException>{ValidationUtil.validateCarNames("longname,over5length")}
    }

    @Test
    fun `자동차 이름은 한글, 영어, 숫자 이외의 문자를 사용할 수 없습니다`() {
        assertDoesNotThrow{ValidationUtil.validateCarNames("hodu,우테코,6기")}
        assertThrows<IllegalArgumentException>{ValidationUtil.validateCarNames("-,:,?")}
    }
}
