package view

import model.Name
import model.TryCount

interface InputViewInterface {
    fun inputName(): Name
    fun inputTryCount(): TryCount
}
