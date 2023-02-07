import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class InputView {
    private val br = BufferedReader(InputStreamReader(System.`in`))
    private val bw = BufferedWriter(OutputStreamWriter(System.`out`))

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
