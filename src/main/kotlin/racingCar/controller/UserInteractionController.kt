package racingCar.controller

import racingCar.model.CarName
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
        cars.parsedCars.forEach { car ->
            OutputView.printMessage("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        OutputView.printMessage("\n")
    }

    fun handleWinnerMessage(winners: List<CarName>) {
        OutputView.printMessage("최종 우승자: ${winners.joinToString(", ")}")
    }
}
