interface B<T> {
    val bar: T
}

class S(val value: String) {

    fun bar() = value

    fun foo(): B<String> {
        val p  = S("OK");
        return object : B<String> {
            override val bar: String = p.bar()
        }
    }
}

fun box(): String {
    return S("fail").foo().bar
}

// 0 this$0