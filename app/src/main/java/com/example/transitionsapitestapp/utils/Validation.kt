package com.example.transitionsapitestapp.utils

object Validation {

    fun validate(string: String): Boolean{
        return isEmpty(string) && validateChars(string)
    }

    private fun isEmpty(string: String): Boolean{
        return string.trim().isNotEmpty()
    }

    private fun validateChars(string: String):Boolean{
        return !string.contains("!") &&
                !string.contains("?") &&
                !string.contains("*") &&
                !string.contains("%") &&
                !string.contains("^") &&
                !string.contains("#") &&
                !string.contains("$") &&
                !string.contains("@") &&
                !string.contains(":") &&
                !string.contains(";") &&
                !string.contains("]") &&
                !string.contains("[") &&
                !string.contains("{") &&
                !string.contains("}") &&
                !string.contains("=") &&
                !string.contains("+") &&
                !string.contains("(") &&
                !string.contains(")") &&
                !string.contains("1") &&
                !string.contains("2") &&
                !string.contains("3") &&
                !string.contains("4") &&
                !string.contains("5") &&
                !string.contains("6") &&
                !string.contains("7") &&
                !string.contains("8") &&
                !string.contains("9") &&
                !string.contains("0") &&
                !string.contains(">") &&
                !string.contains("<") &&
                !string.contains(".") &&
                !string.contains(",") &&
                !string.contains("№") &&
                !string.contains("~") &&
                !string.contains("`")
    }

    private fun validatePasswordAndLogin(string: String):Boolean{
        return !string.contains("!") &&
                !string.contains("?") &&
                !string.contains("*") &&
                !string.contains("%") &&
                !string.contains("^") &&
                !string.contains("#") &&
                !string.contains("$") &&
                !string.contains("@") &&
                !string.contains(":") &&
                !string.contains(";") &&
                !string.contains("]") &&
                !string.contains("[") &&
                !string.contains("{") &&
                !string.contains("}") &&
                !string.contains("=") &&
                !string.contains("+") &&
                !string.contains("(") &&
                !string.contains(")") &&
                !string.contains(">") &&
                !string.contains("<") &&
                !string.contains(".") &&
                !string.contains(",") &&
                !string.contains("№") &&
                !string.contains("~") &&
                !string.contains("`")
    }
}