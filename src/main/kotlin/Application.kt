import controller.RacingGameController
import service.RacingCarGameService
import service.RandomNumberGenerator
import validation.NameValidation
import validation.TryCountValidation
import view.InputView
import view.OutputView

fun main() {
    RacingGameController(
        NameValidation(),
        TryCountValidation(),
        InputView(),
        OutputView(),
        RacingCarGameService(RandomNumberGenerator())
    ).run()
}
