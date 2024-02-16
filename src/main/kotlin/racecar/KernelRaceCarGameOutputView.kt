package racecar

class KernelRaceCarGameOutputView : RaceCarGameOutputView {
    override fun outputCarNamesRequest() = println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

    override fun outputTrialCountRequest() = println("시도할 횟수는 몇 회인가요?")

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
