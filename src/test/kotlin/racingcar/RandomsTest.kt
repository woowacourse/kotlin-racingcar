package racingcar

import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeBetween
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RandomsTest {

    @DisplayName("범위 내의 랜덤 숫자를 amount개 가져온다")
    @Test
    fun generateRandoms() {
        val randoms = Randoms(3)
        val moveFactors = randoms.generate()

        moveFactors shouldHaveSize 3
    }

    @DisplayName("generate 시 입력한 파라미터 범위 내의 숫자를 발생한다.")
    @Test
    fun generateInRange() {
        val randoms = Randoms(3)
        val moveFactors = randoms.generate()

        moveFactors.forAll {
            it.shouldBeBetween(0, 9)
        }
    }
}
