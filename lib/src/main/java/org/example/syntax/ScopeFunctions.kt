package org.example.syntax

class ScopeFunctions {
    companion object {
        private fun processNonNullString(str: String) {}

        fun nullableLet(greeting: String?): Int {
            val str: String? = greeting
//            processNonNullString(str) // compilation error: Type mismatch between String? and String
            val length = str?.let {
                println("let() called on $it") // let() called on $it
                processNonNullString(it) // OK: 'it' is not null inside '?.let { }'
                it.length
            }
            return length ?: 0
        }

        fun notUsingLet(): Fan {
            val fan = Fan("Jim")
            fan.name = "Jo"
            fan.showsAttended = 11
            println("Fan name updated to $fan.name, fan shows attended updated to ${fan.showsAttended}")
            return fan
        }

        fun usingLet(): Fan {
            val fan = Fan("Jim")
            return fan.let {
                it.name = "Jo"
                it.showsAttended = 11
                println("Fan name updated to $it.name, fan shows attended updated to ${it.showsAttended}")
                it
            }
        }

        fun notUsingWith(): Fan {
            val fan = Fan("John", 30)
            fan.name = "Jane"
            fan.showsAttended++
            return fan
        }

        fun usingWith(): Fan {
            val fan = Fan("John", 30)
            return with(fan) {
                name = "Jane"
                showsAttended++
                this
            }
        }

        fun usingRun(): Fan {
            val fan = Fan("Jim", 5)
            return fan.run {
                name = "Bob"
                showsAttended = 0
                this
            }
        }

        fun usingApply(): Fan {
            return Fan("Jemma").apply {
                showsAttended = 44
            }.apply {
                println("Shows attended: ${this.showsAttended}")
            }
        }

        fun usingAlso(): MutableList<Fan> {
            val fans = mutableListOf(Fan("Bob"), Fan("Jemma", 44))
            fans.also {
                println("Sending offers to existing fans: $it")
                println("Offers sent")
            }.add(Fan("Jill", 0)) // Also is run before add
            return fans
        }
    }
}