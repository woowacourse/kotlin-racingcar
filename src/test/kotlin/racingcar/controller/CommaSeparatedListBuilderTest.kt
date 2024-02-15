package racingcar.controller

import org.junit.jupiter.api.BeforeEach

class CommaSeparatedListBuilderTest {
    private lateinit var commaSeparatedListBuilder: CommaSeparatedListBuilder

    @BeforeEach
    fun setup() {
        commaSeparatedListBuilder = CommaSeparatedListBuilder()
    }
}