package racingCar

class Referee {
    fun isCarAbleToMove(randomNumber: Int): Boolean = randomNumber >= MIN_RANDOM_AVAILABILITY_CONDITION

    fun selectWinnerNames(raceCars: List<Car>): List<String> {
        val maxPosition = findMaxPosition(raceCars)
        return raceCars
            .filter { raceCar ->
                raceCar.position == maxPosition
            }.map { winner -> winner.name }
    }

    private fun findMaxPosition(raceCars: List<Car>) = raceCars.maxOf { raceCar -> raceCar.position }

    companion object {
        private const val MIN_RANDOM_AVAILABILITY_CONDITION = 4
    }
}
