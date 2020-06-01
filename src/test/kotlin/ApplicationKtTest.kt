import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApplicationKtTest {
    @Test
    internal fun test() {
        val test = "Test";

        assertThat(test).isEqualTo("Test")
    }
}