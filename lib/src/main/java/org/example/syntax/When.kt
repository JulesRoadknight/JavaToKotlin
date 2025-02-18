package org.example.syntax

class When {
    // Companion object is an object associated to a class, with access to its members.
    // It's used here to make the methods contained static.
    companion object {
        fun whatNumber(number: Int): String {
            return when (number) {
                1 -> "One"
                2 -> "Two"
                3 -> {
                    println("Matched three!")
                    "Three"
                }

                4, 5 -> "Getting higher"
                in 6..10 -> "Wow, big number"
                else -> "Unknown"
            }
        }

        fun oddOrEven(number: Int): String {
            return when {
                number % 2 == 1 -> "Odd number"
                number % 2 == 0 -> "Even number"
                else -> "How did you do that?"
            }
        }
    }
}