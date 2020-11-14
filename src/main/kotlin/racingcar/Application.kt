package racingcar

import racingcar.domain.CarFactory
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.TryCount
import racingcar.utils.CarNameParser
import racingcar.view.InputView
import java.lang.Integer.parseInt
import java.util.stream.Collectors

fun main() {
    val carNames = CarNameParser.parse(InputView.carNames())
    val tryCount = TryCount(parseInt(InputView.tryCount()))
    val cars = Cars(CarFactory.create(carNames))

    val gameResult = RacingGame.start(cars, tryCount);

    println("실행 결과")
    gameResult.forEachIndexed { index, racingHistory ->
        println("${racingHistory.name} : ${"-".repeat(racingHistory.position.position)}")
        if (isRoundOver(index, cars)) println()
    }
    println(findWinner(cars) + "가 최종 우승했습니다.")
}

private fun findWinner(cars: Cars): String? {
    return cars.winner.stream()
        .map { it.name }
        .collect(Collectors.joining(", "))
}

private fun isRoundOver(index: Int, cars: Cars) = (index + 1) % cars.size == 0
