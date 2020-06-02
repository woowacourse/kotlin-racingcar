package racing

import racing.domain.Cars
import racing.ui.ConsoleView

object RacingCarGame {
    fun run() {
        val cars = Cars(ConsoleView.getCarQuantityInput())
        repeat(ConsoleView.getRaceRoundInput()) {
            cars.race()
            ConsoleView.race(cars)
        }
    }
}
