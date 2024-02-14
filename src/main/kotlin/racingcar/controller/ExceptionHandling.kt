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
    fun limitNumberOfCars(numberOfCars: Int): Boolean{
        return try{
            require(numberOfCars in 1..100)
            false
        } catch(ex: IllegalArgumentException){
            println(Messages.NUMBER_OF_CAR_ERROR)
            true
        }
    }
    fun duplicatedCarName(carNames: List<String>): Boolean{
        return try{
            require(carNames.size == carNames.toSet().size)
            false
        } catch(ex: IllegalArgumentException){
            println(Messages.DUPLICATED_CAR_NAME_ERROR)
            true
        }
    }
}
