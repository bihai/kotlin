package pack

@deprecated("", ReplaceWith("newFun(p + 1)", "newPack.newFun"))
fun oldFun(p: Int) {
    newFun(p + 1)
}
