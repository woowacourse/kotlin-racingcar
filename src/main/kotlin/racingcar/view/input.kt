package racingcar.view

fun inputCar(): List<String> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으루 구분).")
    val read = readLine().toString()
    var carNames = read.split(",").map { it.trim() }
    for (name in carNames) {
        require(name.length <= 5)
    }

    return carNames
}

fun inputTry() {
    println("시도할 횟수는 몇 회인가요?")
}