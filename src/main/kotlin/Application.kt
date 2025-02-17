import controller.RaceController
import view.InView
import view.OutView

fun main() {
    val mainController = RaceController(InView(), OutView())
    mainController.runProgram()
}
