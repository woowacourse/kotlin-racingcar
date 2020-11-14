package racingcar

import racingcar.domain.TryCount
import racingcar.utils.CarNameParser
import racingcar.view.InputView
import java.lang.Integer.parseInt

fun main() {
    val carNames = CarNameParser.parse(InputView.carNames())
    val tryCount = TryCount(parseInt(InputView.tryCount()))

}
