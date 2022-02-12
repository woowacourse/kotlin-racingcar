package water.racingcar.util

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeInRange

internal class RandomGeneratorTest: BehaviorSpec ({
    val randomGenerator = RandomGenerator()
    given("RandomGeneratorTest 클래스에서"){
        `when`("랜덤 번호를 생성하면"){
            then("랜덤 숫자는 0이상 9이하여야 한다."){
                randomGenerator.generateRandomNumber() shouldBeInRange 0..9
            }
        }
    }
})