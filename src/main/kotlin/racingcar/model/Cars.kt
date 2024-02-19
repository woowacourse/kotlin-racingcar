package racingcar.model

import racingcar.validator.Validation

class Cars(names: List<String>) {
    init {
        Validation().carNameList(names)
    }
}