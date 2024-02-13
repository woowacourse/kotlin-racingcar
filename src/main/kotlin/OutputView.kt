object OutputView {
    fun printInputCars() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printInputTrialCount() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printRaceResult(result: String) {
        println("실행 결과")
        println(result)
    }

    fun printWinner(winner: String) {
        print("최종 우승자: $winner")
    }
}