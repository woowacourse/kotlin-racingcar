package racingcar.view

class OutputView {

    fun printCarsPosition(carDtos: List<CarDto>) {
        carDtos.forEach { println(generateCarInfo(it)) }
        println()
    }

    private fun generateCarInfo(carDto: CarDto): String {
        return "${carDto.name} : ${"-".repeat(carDto.position)}"
    }

    fun printWinners(carDtos: List<CarDto>) {
        println("최종 우승자: ${carDtos.joinToString(",") { it.name }}")
    }
}
