import domain.Car
import domain.Cars
import view.InputView
import view.OutputView

private const val INIT_NUMBER = 1
private const val PIVOT = 4
private val RANGE = (0..9)

fun main() {
    val countOfCar = InputView.receiveCountOfCar()
    val countOfTry = InputView.receiveCountOfTry()

    val moveStrategy = { RANGE.random() >= PIVOT }
    val cars = Cars((INIT_NUMBER..countOfCar).map { Car(moveStrategy = moveStrategy) })

    OutputView.showResult()
    for (i in (INIT_NUMBER..countOfTry)) {
        cars.move()
        OutputView.showCars(cars.values())
    }
}
