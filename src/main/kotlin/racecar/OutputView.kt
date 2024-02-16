class OutputView {
    fun outputCarNamesRequest() = println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

    fun outputTrialCountRequest() = println("시도할 횟수는 몇 회인가요?")

    fun outputRaceResultTitle() = println("실행 결과")

    fun outputCarStatus(status: String) = println(status)

    fun outputWinners(winner: String) = print(winner)
}
