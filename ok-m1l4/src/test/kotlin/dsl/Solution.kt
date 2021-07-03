package dsl

import java.lang.RuntimeException

class SqlSelectBuilder {
    var query = ""
    fun from(value: String) {
        if (query.isEmpty()) query += "select *"
        query += " from $value"
    }

    fun build(): String {
        return query
    }

    fun select(value: String, s: String? = null) {
        s?.let { query = "select $value, $s" } ?: throw Exception("wrong s parameter")
    }

    fun where(value: () -> String?) {
        query += " where ${value.invoke()}"
    }

    fun or(b: () -> String?): String {
        return "or"
    }

    infix fun String.eq(s: Any): String {
        return when (s) {
            is String -> "$this = '$s'"
            is Int -> "$this = $s"
            else -> throw RuntimeException("unexpected Type")
        }
    }

    infix fun String.nonEq(s: Any?): String? {
        return when (s) {
            is String -> "$this != '$s'"
            is Int -> "$this != $s"
            else -> null
        }
    }
}

fun query(init: SqlSelectBuilder.() -> Unit): SqlSelectBuilder {
    return SqlSelectBuilder().apply(init)
}


@DslMarker
annotation class SqlDslMarker

