import java.util.LinkedList

class NumbersExtractor(numbers: List<Int>) : NumberStrategy {
    private val numbers = LinkedList(numbers)
    val currentNumbersSize get() = numbers.size

    override fun getNumber(): Int {
        require(numbers.isNotEmpty()) { "[ERROR] 모든 숫자를 추출 하였습니다" }
        return numbers.poll()
    }
}
