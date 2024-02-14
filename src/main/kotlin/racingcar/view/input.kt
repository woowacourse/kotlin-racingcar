package racingcar.view

fun inputCarName(): String {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으루 구분).")
    val carNames = readLine().toString()
    return carNames
}

fun inputTryCnt() {
    println("시도할 횟수는 몇 회인가요?")
}