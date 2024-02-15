package racingcar.controller

import racingcar.model.Messages

class ExceptionHandling {

    fun limitNumberOfAttempts(numberOfAttempts: Int): Boolean{
        return try{
            require(numberOfAttempts in 1..10000)
            true
        } catch(ex: IllegalArgumentException){
            println(Messages.NUMBER_OF_ATTEMPTS_ERROR)
            false
        }
    }
    fun nameFormat(names: String): Boolean{
        val regex = Regex("^[a-zA-Z가-힣,]+\$")
        return try{
            require(regex.matches(names))
            true
        } catch(ex: IllegalArgumentException){
            println(Messages.NAME_FORMAT_ERROR)
            false
        }
    }
    fun limitNumberOfCars(numberOfCars: Int): Boolean{
        return try{
            require(numberOfCars in 1..100)
            true
        } catch(ex: IllegalArgumentException){
            println(Messages.NUMBER_OF_CAR_ERROR)
            false
        }
    }
    fun duplicatedCarName(carNames: List<String>): Boolean{
        return try{
            require(carNames.size == carNames.toSet().size)
            true
        } catch(ex: IllegalArgumentException){
            println(Messages.DUPLICATED_CAR_NAME_ERROR)
            false
        }
    }
}
