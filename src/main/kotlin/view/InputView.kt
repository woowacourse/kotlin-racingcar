package view

private const val MIN_COUNT = 1

object InputView {
    fun receiveCountOfCar(): Int {
        println("자동차 대수는 몇 대 인가요?")
        val count = readLine()!!.toInt()
        require(count >= MIN_COUNT, { "자동차의 대수는 1대 이상이어야 합니다." })
        return count
    }

    fun receiveCountOfTry(): Int {
        println("시도할 회수는 몇 회 인가요?")
        val count = readLine()!!.toInt()
        require(count >= MIN_COUNT, { "시도할 회수는 1회 이상이어야 합니다." })
        return count
    }
}