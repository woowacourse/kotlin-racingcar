class Output {
    fun printRaceCarNamesGuide() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printRaceCountGuide() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printRaceResultTitle() {
        println("\n실행 결과")
    }

    fun printRaceProgress(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}
