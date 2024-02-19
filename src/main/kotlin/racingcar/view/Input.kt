package racingcar.view

class Input {
    fun inputCar(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으루 구분).")
        val read = readLine().toString()
        require(read.contains(SPLITTER))

        return read.split(SPLITTER)
    }

    fun inputTry(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val read = readLine().toString()

        return read.toInt()
    }

    companion object {
        const val SPLITTER = ","
    }
}
