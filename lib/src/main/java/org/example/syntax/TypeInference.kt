package org.example.syntax

class TypeInference {
    val shouldBeAString = returnString()            // String
    val mayBeAString = returnStringOrNull()         // String?
    val mayAlsoBeAString = null ?: "String Value"   // String
    var nullValueVariable = null                    // Nothing?
    val nullValueConstant: Nothing? = null          // Nothing?
    var intValue = 100                              // Int
    var booleanValue = true                         // Boolean

    fun returnString(): String {
        return "String"
    }

    fun returnStringOrNull(input: String = ""): String? {
        if (input == "") {
            return null
        }
        return input
    }

    fun updateNullValue() {
//        nullValueConstant = true // Val cannot be reassigned
//        nullValueVariable = true // The boolean literal does not conform to the expected type Nothing?
    }

    fun switchBoolean() {
        booleanValue = !booleanValue
    }

    fun useAllVariables() {
        shouldBeAString
        mayBeAString
        mayAlsoBeAString
        nullValueConstant
        nullValueVariable
        intValue
        booleanValue
    }
}