import java.util.LinkedList

class AnonymousNumbersExtractor(numbers: List<Int>) : AnonymousNumberStrategy {
    private val anonymousNumbers = numbers.toMutableList()

    override fun getNumber(excludeNumbers: Set<Int>): Int {
        anonymousNumbers.removeAll(excludeNumbers)
        return LinkedList(anonymousNumbers).poll()
    }
}
