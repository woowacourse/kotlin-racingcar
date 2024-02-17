package racingcar.controller

class FinalWinner {
    fun decideWinner(cars: List<Car>): List<String> {
        val winnersPosition = cars.maxOf { it.position.length }

        return cars.filter { it.position.length == winnersPosition }.map { it.name }
    }
}
