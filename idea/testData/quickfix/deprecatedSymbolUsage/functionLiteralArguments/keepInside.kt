// "Replace with 'newFun(p1, null, p2)'" "true"

interface I {
    @deprecated("", ReplaceWith("newFun(p1, null, p2)"))
    fun oldFun(p1: String, p2: () -> Boolean)

    fun newFun(p1: String, p2: String?, p3: () -> Boolean)
}

fun foo(i: I) {
    i.<caret>oldFun("a", { true })
}
