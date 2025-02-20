package org.example.syntax

class ScopeFunctions {
    companion object {
        fun notUsingScopeFunctions(): Pair<String, Int> {
            val fan = FanDataClass("Jim")
            fan.name = "Jo"
            fan.showsAttended = 11
            println("Fan name updated to $fan.name, fan shows attended updated to ${fan.showsAttended}")
            return Pair(fan.name, fan.showsAttended)
        }

        fun usingLet(): Pair<FanDataClass, String> {
            val fan = FanDataClass("Jim")
            return fan.let {
                it.name = "Jo"
                it.showsAttended = 11
                val successMessage = "Fan name updated to $it.name, fan shows attended updated to ${it.showsAttended}"
                Pair(it, successMessage)
            }
        }

        fun usingWith(): FanDataClass {
            val fan = FanDataClass("John", 30)
            return with(fan) {
                name = "Jane"
                showsAttended++
                this
            }
        }

        fun usingRun(): FanDataClass {
            val fan = FanDataClass("Jim", 5)
            return fan.run {
                name = "Bob"
                showsAttended = 0
                this
            }
        }

        fun usingApply(): FanDataClass {
            return FanDataClass("Jemma").apply {
                showsAttended = 44
            }.apply {
                println("Shows attended: ${this.showsAttended}")
            }
        }

        fun usingAlso(): MutableList<FanDataClass> {
            val fans = mutableListOf(FanDataClass("Bob"), FanDataClass("Jemma", 44))
            fans.also {
                println("Sending offers to existing fans: $it")
                println("Offers sent")
            }.add(FanDataClass("Jill", 0)) // Also is run before add
            return fans
        }
    }
}