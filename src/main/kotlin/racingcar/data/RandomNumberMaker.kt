package racingcar.data

interface RandomNumberMaker {
    fun makeRandomNumber(
        minNumber: Int,
        maxNumber: Int
    ): Int
}
