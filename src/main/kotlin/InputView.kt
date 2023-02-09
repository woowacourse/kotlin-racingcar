import View.br
import View.bw

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
