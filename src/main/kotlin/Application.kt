import view.InputView
import view.OutputView

fun main(){

    val inputView = InputView()
    val outputView = OutputView()

    RacingController(
        inputView = inputView,
        outputView = outputView
    ).run()
}