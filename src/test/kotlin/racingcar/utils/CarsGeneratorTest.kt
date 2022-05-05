package racingcar.utils

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class CarsGeneratorTest {
    @Test
    @DisplayName("올바른 입력일 때 자동차들을 정상적으로 생성해야 합니다.")
    fun saveCars() {
        generateCars("pobi,crong,honux")
            .shouldHaveSize(3)
            .shouldContainAll(Car("pobi"), Car("crong"), Car("honux"))
    }
}
