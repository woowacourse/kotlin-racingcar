import controller.RacingGameController
import service.RacingCarGameService
import service.RandomNumberGenerator
import view.InputView
import view.OutputView

fun main() {
    RacingGameController(
        InputView(),
        OutputView(),
        RacingCarGameService(RandomNumberGenerator())
    ).run()
}
