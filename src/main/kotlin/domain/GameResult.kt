package domain

class GameResult(
    private val cars: List<Car>,
) {
    fun getFinalResult(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.currentPosition }
        val winnerList = cars.filter { it.currentPosition == maxPosition }
        return winnerList
    }
}
