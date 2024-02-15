package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CommaSeparatedListBuilderTest {
    private lateinit var commaSeparatedListBuilder: CommaSeparatedListBuilder

    @BeforeEach
    fun setup() {
        commaSeparatedListBuilder = CommaSeparatedListBuilder()
    }

    @ParameterizedTest
    @ValueSource(strings = ["alsong,haeum,pobi", "alsong, haeum, pobi"])
    fun `문자열을 쉼표로 기준으로 나눠서 리스트로 반환하는지`(input: String) {
        val result = commaSeparatedListBuilder.commaSeparatedListBuild(input)
        assertThat(result).isEqualTo(listOf("alsong", "haeum", "pobi"))
    }
}
