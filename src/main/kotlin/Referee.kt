class Referee {

    fun decideWinner(cars: List<Car>): List<String> {
        val maxScore = cars.getMaxScore()

        val winners = cars.filter { car ->
            car.getCar().second == maxScore
        }.map { car ->
            car.getCar().first
        }

        return winners
    }

    private fun List<Car>.getMaxScore(): Int = this.maxBy { car ->
        car.getCar().second
    }.getCar().second
}
