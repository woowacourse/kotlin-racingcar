import view.InputView

class RacingController(private val inputView: InputView) {
    private lateinit var carNames: List<String>

    fun run(){
        carNames = splitCarNames(inputView.inputCarNames())

    }

    private fun splitCarNames(inputCarNames: String): List<String> {
        return inputCarNames.split(',')
    }
}