package racingcar.model

class RacingGame(private val carNames: MutableList<Car>) {
    private fun generateRandomNumber(): Int = randomNumber.random()

    fun decideWinner(cars: List<Car>): List<String> {
        val winnersPosition = cars.maxOf { it.position.length }

        return cars.filter { it.position.length == winnersPosition }.map { it.name }
    }

    fun carMovingControl(){
        carNames.forEach { car ->
            val randomNumber = generateRandomNumber()
            car.moveCar(randomNumber)
        }
    }

    companion object{
        private val randomNumber = 0..9
    }
}