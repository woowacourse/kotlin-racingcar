import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

data class Product(
    val name: String,
    val price: Double,
    val onSale: Boolean = false,
)

data class OrderItem(
    val products: Product,
    val quantity: Int,
)

class Test {
    @Test
    fun test() {
        val item1 = OrderItem(Product("baseball", 10.0), 5)
        val item2 = item1.copy()

        assertAll(
            { assertTrue(item1 == item2) },
            { assertFalse(item1 === item2) },
            { assertTrue(item1.products == item2.products) },
            { assertTrue(item1.products === item2.products) },
        )
    }
}
