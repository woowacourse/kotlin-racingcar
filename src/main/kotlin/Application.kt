import controller.GameController
import exception.InvalidCarNameException
import view.View

fun main() {
    val gameController = GameController(View())

    try {
        gameController.gameStart()
    } catch (e: IllegalArgumentException) {
        View().printInvalidGameInfo()
        gameController.gameStart()
    } catch (e: InvalidCarNameException) {
        View().printInvalidGameInfo()
        gameController.gameStart()
    } catch (e: NumberFormatException) {
        View().printInvalidGameInfo()
        gameController.gameStart()
    }
}
