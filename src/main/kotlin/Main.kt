fun main() {
    val cars: List<Car> = readCars()
    val round: Int = readRound()
    println("\n실행결과")
    val racecourse = Racecourse(cars, round)
    racecourse.startRace()

}

fun readCars(): List<Car> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val userInput: String? = readlnOrNull()
    val cars: List<Car> = userInput!!.split(",").map { it.trim() }.map { name -> Car(name) }
    return cars
}


fun readRound(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val round = readlnOrNull()!!
    return round.toInt()
}