package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.match

internal class CarsTest : StringSpec({
    "중복된 자동차 이름이 있으면 예외를 발생시킨다." {
        shouldThrow<IllegalArgumentException> { Cars.fromNames(listOf("자동차", "자동차")) }
            .message should match("자동차 이름은 중복될 수 없습니다.")
    }

    "자동차들을 전진시킬 수 있다." {
        val cars = Cars.fromNames(listOf("자동차1", "자동차2"))

        cars.move { 4 }

        cars.items.forEach { it.position shouldBe Position(1) }
    }

    "우승자들을 구할 수 있다." {
        val cars = Cars.fromNames(listOf("우승자", "그냥자동차"))
        var index = 0

        cars.move {
            4 - index++
        }

        cars.winners.map { it.name }.toList().shouldContainExactly(Name("우승자"))
    }
})
