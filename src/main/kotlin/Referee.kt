class Referee {

    fun decideWinner(cars: List<Car>): List<Car> {
        val maxScore = cars.getMaxScore()

        val winner = cars.filter { car ->
            car.getCar().second == maxScore
        }

        return winner
    }

    private fun List<Car>.getMaxScore() = this.maxBy { car ->
        car.getCar().second
    }.getCar().second
}
