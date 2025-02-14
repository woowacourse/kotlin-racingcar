package racingCar

class Judge {
    fun isCarAbleToMove(randomNumber: Int): Boolean = randomNumber >= MIN_RANDOM_AVAILABILITY_CONDITION

    fun selectWinnerNames(raceCars: List<Car>): List<String> {
        val maxPosition = raceCars.maxOf { raceCar -> raceCar.position }
        return raceCars
            .filter { raceCar ->
                raceCar.position == maxPosition
            }.map { winner -> winner.name }
    }

    companion object {
        private const val MIN_RANDOM_AVAILABILITY_CONDITION = 4
    }
}
