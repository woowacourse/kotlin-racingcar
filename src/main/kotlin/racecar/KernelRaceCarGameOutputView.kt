package racecar

class KernelRaceCarGameOutputView : RaceCarGameOutputView {
    override fun outputRaceResultTitle() = println("실행 결과")

    override fun outputRacingStatus(cars: List<RaceCar>) {
        println(cars.formatToRaceStatus())
    }

    override fun outputWinners(winner: List<RaceCar>) = print(winner.formatToWinners())

    private fun List<RaceCar>.formatToRaceStatus() =
        StringBuilder()
            .also { sb -> forEach { car -> sb.append("${car.formatToStatus()}\n") } }
            .toString()

    private fun List<RaceCar>.formatToWinners() = "최종 우승자: ${joinToString { it.name }}"

    private fun RaceCar.formatToStatus(): String = "$name : ${DISTANCE_UNIT.repeat(position)}"

    companion object {
        private const val DISTANCE_UNIT = "-"
    }
}
