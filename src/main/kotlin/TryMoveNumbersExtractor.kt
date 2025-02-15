import java.util.LinkedList

class TryMoveNumbersExtractor(numbers: List<Int>) : TryMoveNumberStrategy {
    private val numbers = LinkedList(numbers)
    val currentNumbersSize get() = numbers.size

    override fun getNumber(): Int {
        require(numbers.isNotEmpty()) { EXTRACTOR_EMPTY_ERROR }
        return numbers.poll()
    }

    companion object {
        private const val EXTRACTOR_EMPTY_ERROR = "[ERROR] 모든 숫자를 추출 하였습니다 더 이상 추출 할 수 없습니다."
    }
}
