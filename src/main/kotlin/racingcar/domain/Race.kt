package racingcar.domain

class Race(val cars: List<Car>) {
    fun getPositions(): List<Int> {
        val generateRandomNumber = GenerateRandomNumber()
        val roundResults = mutableListOf<Int>()
        cars.forEach { car ->
            val randomNumber = generateRandomNumber.randomNumber()
            car.moves(randomNumber)
            roundResults.add(car.position)
        }
        return roundResults
    }

    fun getWinners(): List<String> {
        val maxNumber = cars.maxOfOrNull { it.position }
        val winners =
            cars.filter { car ->
                car.position == maxNumber
            }.map { it.carName }
        return winners
    }
}
