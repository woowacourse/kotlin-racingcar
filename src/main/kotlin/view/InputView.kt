package view

import util.CAR_NAMES_REQUEST_MSG
import util.NUMBER_OF_TRY_REQUEST_MSG
import view.View.br
import view.View.bw

object InputView {

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
