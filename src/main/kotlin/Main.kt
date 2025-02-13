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
    if (checkCarNameValid(userInput)) {
        return userInput!!.toCars()
    }
    println("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.")
    return readCars()
}

fun checkCarNameValid(userInput: String?): Boolean {
    if (userInput == null) return false
    val cars = userInput.toCars()
    return cars.all { car -> car.name.length <= 5 }
}

fun String.toCars(): List<Car> =
    split(",")
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .map { name -> Car(name) }

fun readRound(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val userInput: String? = readlnOrNull()
    if (checkRoundValid(userInput)) {
        return userInput!!.toInt()
    }
    println("올바른 숫자를 입력하세요.")
    return readRound()
}

fun checkRoundValid(userInput: String?): Boolean {
    if (userInput == null) return false
    if (userInput.toIntOrNull() == null) return false
    if (userInput.toInt() <= 0) return false
    return true
}
