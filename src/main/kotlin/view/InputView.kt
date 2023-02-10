package view

import view.View.br
import view.View.bw

object InputView {

    private const val CAR_NAMES_REQUEST_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n"
    private const val NUMBER_OF_TRY_REQUEST_MSG = "시도할 횟수는 몇 회인가요?\n"

    fun inputCarNames(): String {
        bw.write(CAR_NAMES_REQUEST_MSG)
        bw.flush()

        return br.readLine()
    }

    fun inputNumberOfTry(): String {
        bw.write(NUMBER_OF_TRY_REQUEST_MSG)
        bw.flush()

        return br.readLine()
    }
}
