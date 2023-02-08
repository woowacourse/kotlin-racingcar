import View.br
import View.bw

object InputView {

    fun inputCarNames(): String {
        bw.write("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        bw.flush()

        return br.readLine()
    }

    fun inputNumberOfTry(): String {
        bw.write("시도할 횟수는 몇 회인가요?")
        bw.flush()

        return br.readLine()
    }
}
