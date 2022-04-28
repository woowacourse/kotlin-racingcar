package racingcar

import java.util.stream.Collectors

class Cars private constructor(val cars: List<Car>) {

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

    fun moveAll(moveFactors: List<Int>) {
        validateMoveFactors(moveFactors)
        for (idx in moveFactors.indices) {
            cars[idx].move(moveFactors[idx])
        }
    }

    private fun validateMoveFactors(moveFactors: List<Int>) {
        if (moveFactors.size != cars.size) {
            throw IllegalArgumentException("[ERROR] 이동 요소 입력을 다시해주세요.")
        }
    }
}
