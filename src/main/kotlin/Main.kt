fun main() {
    val cars: List<Car> = readCars()
    val round: Int = readRound()
    println("\n실행결과")
    val racecourse = Racecourse(cars, round)
    racecourse.startRace()
}

fun readCars(): List<Car> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    while (true) {
        val userInput = readlnOrNull()
        userInput?.let {
            val cars = it.toCars()
            if (cars.all { car -> car.name.length <= 5 }) {
                return cars
            }
        }
        println("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.")
    }
}

fun String.toCars(): List<Car> =
    split(",")
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .map { name -> Car(name) }

fun isCarNameValid(car: Car): Boolean = car.name.length <= 5

fun readRound(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readlnOrNull()?.toIntOrNull() ?: run {
        println("올바른 숫자를 입력하세요.")
        readRound()
    }
}
