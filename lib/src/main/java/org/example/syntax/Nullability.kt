package org.example.syntax

class Nullability {
    fun nullSafeOperatorWithoutElvis(input: String?): String { // String? is nullable
        if (input != null) return input // But this is the Java way of handling null values
        return "Default"
    }

    fun elvisOperator(input: String?): String {
        return input ?: "Default" // Much better. If input is null, return "Default"
    }

    fun assertNotNullOperator(input: String?): Int {
        return input!!.length      // Dangerous! Satisfies return type String, but throws an NPE if it's null
    }

    fun withLet(input: String?): Int {
        val length = input?.let {
            it.length
        }
        return length ?: 0
    }
    /*
        Scope functions like let() treat the context object as NOT NULL
        Even if it is null, calling length() on it will not throw an NPE, unlike using !!
     */
}