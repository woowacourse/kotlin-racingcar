object OutputView {
    fun outputCarNamesRequest() = println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

    fun outputTrialCountRequest() = println("시도할 횟수는 몇 회인가요?")

    fun outputRaceResult(result: String) {
        println("실행 결과")
        println(result)
    }

    fun outputWinner(winner: String) {
        print("최종 우승자: $winner")
    }
}