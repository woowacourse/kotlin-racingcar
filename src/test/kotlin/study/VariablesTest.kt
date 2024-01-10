package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VariablesTest {

    @Test
    fun val_var_차이() {
        val popcorn = 5;

        // popcorn = 6; // compile error

        var sandwhich = 6;

        sandwhich = 5;

        assertThat(sandwhich).isEqualTo(popcorn);
    }

    @Test
    fun int_자료형_선언() {
        val number: Int;
        number = 3;

        assertThat(number).isEqualTo(3);
    }
}