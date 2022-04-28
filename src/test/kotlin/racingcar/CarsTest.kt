package racingcar

import io.kotest.matchers.throwable.haveMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @Test
    fun nameDuplicateException() {
        assertThrows<IllegalArgumentException> {
            Cars.of(listOf("huni", "huni"))
            haveMessage("[ERROR] 중복된 이름이 존재합니다.")
        }
    }

}
