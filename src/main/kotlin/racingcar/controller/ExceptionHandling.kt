package racingcar.controller

import racingcar.model.Messages

class ExceptionHandling {

    fun limitNumberOfAttempts(numberOfAttempts: Int): Boolean{
        return try{
            require(numberOfAttempts in 1..10000)
            false
        } catch(ex: IllegalArgumentException){
            println(Messages.NUMBER_OF_ATTEMPTS_ERROR)
            true
        }
    }
    fun nameFormat(names: String): Boolean{
        val regex = Regex("^[a-zA-Z가-힣,]+\$")
        return try{
            require(regex.matches(names))
            false
        } catch(ex: IllegalArgumentException){
            println(Messages.NAME_FORMAT_ERROR)
            true
        }
    }
}
