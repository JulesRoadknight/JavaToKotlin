package org.example.syntax

class Variables {
    public var address: String = "Palace"   // `public String address = "Underground";`
    fun updateAddress() {
        address = "Underground"
    }

    var age = 16                            // `int age = 16;`
    private var height: Int = 160           // `private int height = 170;`
    fun updateAgeAndHeight() {
        age = 17
        height = 175
    }
    /*
        `age` may only be implicitly typed,
        but it's still typed as strongly as explicitly typed `height`

        //age = "seventeen" // Type mismatch. Required Int, Found String
        //height = true // The boolean literal does not conform to the expected type Int
    */

    val secretName: String = giveSecretName() // `final String name = giveName();`
    lateinit var publicName: String           // `String publicName;`

    fun name() {
        givePublicName()
    }
    private fun giveSecretName(): String {
        return "Usul"
    }
    private fun givePublicName(name: String = "Muad'dib"): String {
        return name
    }

    //lateinit val isTheKwisatzHaderach: Boolean
        // 'lateinit' modifier is allowed only on mutable properties
        // 'lateinit' modifier is not allowed on properties of primitive types


    /*
        Lists behave the same way, but it's worth bearing in mind that there are two types:
        MutableList and List
        A MutableList assigned to a val can be updated with operations like .add()
        A List assigned to a var can't be updated, but can be overwritten
     */
    private val mutableFansList: MutableList<FanDataClass> = mutableListOf(FanDataClass("Jojo"), FanDataClass("Jane"))

    fun addFanToMutableList(name: String) {
        mutableFansList.add(FanDataClass(name))
    }

    private var immutableFansList: List<FanDataClass> = mutableListOf(FanDataClass("Jojo"), FanDataClass("Jane"))

    fun addFanToImmutableList(name: String) {
        val newFan = FanDataClass(name)
        immutableFansList = immutableFansList + newFan
        //immutableFansList.add(newFan) //
    }
}