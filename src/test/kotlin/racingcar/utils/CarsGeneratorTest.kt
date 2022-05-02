package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class CarsGeneratorTest {
    @Test
    @DisplayName("올바른 입력일 때 자동차들을 정상적으로 생성해야 합니다.")
    fun saveCars() {
        assertThat(generateCars("pobi,crong,honux"))
            .contains(Car("pobi"), Car("crong"), Car("honux"))
    }
}
