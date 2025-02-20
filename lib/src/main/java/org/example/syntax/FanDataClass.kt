package org.example.syntax

data class FanDataClass(var name: String, var showsAttended: Int = 0, private val isASuperFan: Boolean = false) {
    var interest = "Music"
}

/*
    Getters and setters are generated where appropriate.
    Read-only val properties will only have a getter.
    If you type `.get` or `.set`, the autofill will give you the applicable properties


    The compiler derives members from all properties in the constructor (name and showsAttended):
    - equals()
    - hashCode()
    - copy()
    - toString()
    - componentN() // e.g. name is component1(), showsAttended is component(2), isASuperFan
        // isASuperFan is NOT component3()
        // interest is NOT component4()
 */
