# Java to Kotlin

A repo of exercises to ease the transition from Java to Kotlin.

### Requirements

Java 17

### Running and testing

`gradle build`

`gradle test`

### Gilded Rose

A refactoring exercise that requires no previous experience writing Kotlin.
See `gilded-rose-requirements.md` for the full specification, but the gist is that you have a file (`GildedRose.java`) with a single function (`updateQuality()`). This one function is untested and difficult to read, and before you add the new item in the specification, the code needs refactoring, which means it should first be tested.

You can scale this to your experience, from exclusively using syntax already present to refactor it with nothing more than a few functions and `if` statements, to adding interfaces and trying more idiomatic Kotlin.

#### Full Version

0. Convert `GildedRose.java` to Kotlin using IntelliJ's built-in tool. Either `Shift+Command+Alt+J`, or open the `Code` toolbar and select `Convert Java File to Kotlin File` at the bottom. If it asks to convert related code too, allow it. 
1. Test the code. Each bullet point in the specification should have a test.
There's a single test in `GildedRoseTest.java` that will work as a template for all  tests you'll need to complete this, so you don't need to have written a single one in Kotlin before.
2. Refactor the code. If you don't know any Kotlin at all, you should still be able to improve it using what's there already. You can try untangling all of the `if` statements, but my preferred approach is to write new code above what's already there until you've replaced the existing functionality and the old code is inaccessible, then you can just delete the old code.
3. Add the new `Conjured` item.

#### Short Version

If you want to skip straight to **Step 3**, you can open `GildedRoseKotlinExample.kt` and work on that instead. It's ready for you to add the `Conjured` item, and has only had a basic refactor, so you can try out some other syntax if you like.

Suggestions:
- Replace if/else with when()
- 
