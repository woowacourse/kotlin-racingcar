package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import racingcar.domain.Count

class CountTest: AnnotationSpec() {

    @Test
    fun `시도횟수가 1미만일 시 예외`() {
        shouldThrow<IllegalArgumentException> {
            Count(0)
        }
    }

}