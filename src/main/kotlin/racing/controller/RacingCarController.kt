package racing.controller

import racing.model.Car
import racing.model.RacingGame
import racing.view.InputView
import racing.view.OutputView

class RacingCarController {

    private val racingGame = RacingGame()
    private var maxMoveCount = 0

    fun initRace() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val cars = mutableListOf<Car>()
        for (carName in InputView.inputCarNames()) {
            cars.add(Car(carName))
        }
        println("시도할 횟수는 몇 회인가요?")
        maxMoveCount = InputView.inputCount()
        racingGame.initRacing(cars)
        startRacing()
    }

    private fun startRacing() {
        println("실행 결과")
        repeat(maxMoveCount) {
            racingGame.move()
            OutputView.printCurrentPosition(racingGame.getCars())
        }
        OutputView.printWinners(racingGame.getWinners())
    }
}
