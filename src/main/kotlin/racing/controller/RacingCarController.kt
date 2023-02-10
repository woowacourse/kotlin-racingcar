package racing.controller

import racing.model.Car
import racing.model.RacingGame
import racing.view.InputView
import racing.view.OutputView

class RacingCarController {

    fun initRace() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val cars = mutableListOf<Car>()
        for (carName in InputView.inputCarNames()) {
            cars.add(Car(carName))
        }
        println("시도할 횟수는 몇 회인가요?")
        val maxMoveCount = InputView.inputCount()
        val racingGame = RacingGame()
        racingGame.initRacing(cars)
        startRacing(maxMoveCount, racingGame)
    }

    private fun startRacing(maxMoveCount: Int, racingGame: RacingGame) {
        println("실행 결과")
        val carCount = racingGame.getCars().size
        repeat(maxMoveCount) {
            racingGame.moveCars(racingGame.createRandomNumbers(carCount))
            OutputView.printCurrentPosition(racingGame.getCars())
        }
        OutputView.printWinners(racingGame.getWinners())
    }
}
