import view.InputView

class RacingController(private val inputView: InputView) {
    private lateinit var carNames: List<String>
    private var tryNumber: Int = 0

    fun run() {
        carNames = splitCarNames(inputView.inputCarNames())

    }

    private fun splitCarNames(inputCarNames: String): List<String> {
        return inputCarNames.split(',')
    }

    private fun validateCarNames(splitCarNames: List<String>) {
        require(splitCarNames.all { it.length <= 5 }) { "각 자동차 이름은 5자를 초과할 수 없습니다." }
        require(splitCarNames.any { it.isNotEmpty() }) { "각 자동차 이름은 공백이 불가합니다." }
        require(splitCarNames.size == splitCarNames.toSet().size) { "각 자동차 이름은 중복이 불가합니다." }
    }
}