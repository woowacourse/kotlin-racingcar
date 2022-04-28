package racingcar

import java.util.stream.Collectors

class Cars private constructor(cars: List<Car>) {

    init {
        validateDuplicateNames(cars)
    }

    companion object {
        fun of(names : List<String>) : Cars {
            return Cars(names.stream()
                .map { name -> Car(name) }
                .collect(Collectors.toList()))
        }
    }

    private fun validateDuplicateNames(cars: List<Car>) {
        if (cars.size != cars.distinct().size) {
            throw IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다.")
        }
    }
}
