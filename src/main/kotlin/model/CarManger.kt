package model

import constant.ErrorConstant

class CarManger(input: String) {
    private var carNameList: List<String> = listOf()
    private var carList: List<Car> = listOf()

    init {
        carNameList = input.split(",").map { it.trim() }.filter { it.isNotBlank() }
        require(carNameList.distinct().size == carNameList.size) { ErrorConstant.ERROR_SAME_NAME }
        carList = carNameList.map { Car(it, randomMaker = Random()) }.toMutableList()
    }

    fun getCarNameList(): List<String> {
        return carNameList
    }

    fun getCarList(): List<Car> {
        return carList
    }
}
