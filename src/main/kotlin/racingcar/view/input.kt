package racingcar.view

fun inputCar(): String {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으루 구분).")
    val read = readLine().toString()

    return read
}

fun inputTry(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val read = readLine().toString()

    return try {
        read.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자만 입력해주세요.")
    }
}