@file:kotlin.deprecated("message")
@file:suppress(<error>BAR</error>)
@file:suppress(BAZ)

@<error>k</error>otlin.deprecated("message")
@<error>s</error>uppress(<error>BAR</error>)
@<error>s</error>uppress(BAZ)

@file:myAnnotation(1, "string")
@file:boo.myAnnotation(1, <error>BAR</error>)
@file:myAnnotation(N, BAZ)

@<error>m</error>yAnnotation(1, "string")
@<error>b</error>oo.myAnnotation(1, "string")
@<error>m</error>yAnnotation(N, BAZ)

package boo

val BAZ = "baz"
val N = 0

annotation class myAnnotation(val i: Int, val s: String)
