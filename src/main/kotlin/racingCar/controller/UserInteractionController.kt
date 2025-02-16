package racingCar.controller

import racingCar.model.Cars
import racingCar.view.InputView
import racingCar.view.OutputView

class UserInteractionController {
    fun handleStartMessage(): String {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = InputView.getUserInput()
        return input
    }

    fun handleAttemptCountMessage(): String {
        OutputView.printMessage("시도할 횟수는 몇 회인가요?")
        val input = InputView.getUserInput()
        return input
    }

    fun handleStartRoundMessage() {
        OutputView.printMessage("\n실행 결과")
    }

    fun handleRoundResultMessage(cars: Cars) {
        val builder = StringBuilder()
        cars.parsedCars.forEach { car ->
            builder.append(car.name + " : " + "-".repeat(car.position))
            builder.append("\n")
        }
        OutputView.printMessage(builder.toString())
    }

    fun handleWinnerMessage(winners: List<String>) {
        OutputView.printMessage("최종 우승자: ${winners.joinToString(", ")}")
    }
}
