package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.string.match

internal class NameTest : StringSpec({
    "이름이_0자_또는_6자_이상이면_예외를_발생시킨다" {
        listOf("", "123456").forEach { input: String ->
            shouldThrow<IllegalArgumentException> { Name(input) }
                .message should match("자동차 이름은 1자 이상, 5자 이하여야 합니다.")
        }
    }
})

