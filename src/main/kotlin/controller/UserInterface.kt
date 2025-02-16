package controller

import model.Cars
import view.InputView
import view.OutputView

class UserInterface(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun handleStartMessage(): String {
        outputView.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = inputView.getUserInput()
        return input
    }

    fun handleAttemptCountMessage(): String {
        outputView.printMessage("시도할 횟수는 몇 회인가요?")
        val input = inputView.getUserInput()
        return input
    }

    fun handleStartRoundMessage() {
        outputView.printMessage("\n실행 결과")
    }

    fun handleRoundResultMessage(cars: Cars) {
        val builder = StringBuilder()
        cars.parsedCars.forEach { car ->
            builder.append(car.name)
            builder.append(" : ")
            builder.append("-".repeat(car.position))
            builder.append("\n")
        }
        outputView.printMessage(builder.toString())
    }

    fun handleWinnerMessage(winners: List<String>) {
        outputView.printMessage("최종 우승자: " + winners.joinToString(", "))
    }
}
