package water.racingcar.ui

import water.racingcar.dto.InputDto

class GameConsoleInput {
    // 이름과 이동횟수를 입력받아서 이를 dto 객체로 반환한다.
    fun getInputs(): InputDto {
        val carNameList: List<String> = getCarNamesInput()
        val times = getTimesInput()

        return InputDto(carNameList,times)
    }

    // 횟수를 "10"과 같은 숫자로 제대로 입력할 때까지 입력을 계속 받아, 횟수 값을 반환한다.
    private fun getTimesInput(): Int {
        println(PLAY_TIMES_INPUT_INFO_MESSAGE)
        var times = getNumberOfTimes(readLine())
        while (times == null) {
            times = getNumberOfTimes(readLine())
        }
        return times
    }

    // 이름을 콤마로 구분하고 각 이름이 5자 이하로 입력할 때까지 입력을 계속 받아, 이름을 리스트 형태로 반환한다.
    private fun getCarNamesInput(): List<String> {
        println(CAR_NAME_INPUT_INFO_MESSAGE)
        var carNameList: List<String> = ArrayList<String>()
        while (carNameList.isEmpty()) {
            carNameList = getListOfNames(readLine())
        }
        return carNameList
    }

    // 입력받은 값인 횟수가 숫자 형태가 아니라면 null, 숫자라면 숫자를 반환한다.
    fun getNumberOfTimes(input: String?): Int? {
        val times = try {
            input?.toInt()
        } catch (e: NumberFormatException) {
            println("$PLAY_TIMES_ERROR_INFO_MESSAGE\n$PLAY_TIMES_INPUT_INFO_MESSAGE")
            null
        }
        return times
    }

    // 이름이 5자 이상이거나 사용자가 값을 입력하지 않으면 빈 배열을 반환하고 정상적으로 입력했을 경우 리스트 형태로 반환한다.
    fun getListOfNames(input: String?): List<String> {
        val nameList = input?.split(",")
        val exceedNameLimitList  = nameList?.filter { it.length > 5 }

        if (input?.isEmpty() == true || exceedNameLimitList?.isNotEmpty() == true) {
            println(CAR_NAME_INPUT_INFO_MESSAGE)
            return ArrayList()
        }
        return nameList.orEmpty()
    } companion object {
        const val CAR_NAME_INPUT_INFO_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분) "
        const val PLAY_TIMES_INPUT_INFO_MESSAGE = "시도할 회수는 몇회인가요?"
        const val PLAY_TIMES_ERROR_INFO_MESSAGE = "※ 숫자를 입력해주세요. ex) 5"
    }
}