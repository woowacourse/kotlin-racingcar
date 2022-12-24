package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.should
import io.kotest.matchers.string.match

internal class PositionTest : StringSpec({
    "위치 객체를 생성하면 기본값은 0이다." {
        Position().value shouldBeExactly 0
    }

    "위치값이 0 미만이면 예외를 발생시킨다." {
        shouldThrow<IllegalArgumentException> { Position(-1) }
            .message should match("위치는 0 이상이어야 합니다.")
    }

    "위치값 간의 대소 비교가 가능하다." {
        forAll(
            row(Position(), Position(1), -1),
            row(Position(), Position(), 0),
            row(Position(1), Position(), 1)
        ) { position1, position2, expected ->
            position1.compareTo(position2) shouldBeExactly expected
        }
    }
})
