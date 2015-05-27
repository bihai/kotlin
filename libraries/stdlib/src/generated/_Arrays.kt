package kotlin

//
// NOTE THIS FILE IS AUTO-GENERATED by the GenerateStandardLib.kt
// See: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
//

import kotlin.platform.*
import java.util.*

import java.util.Collections // TODO: it's temporary while we have java.util.Collections in js

/**
 * Returns the Iterable that wraps the original array
 */
public fun <T> Array<out T>.asIterable(): Iterable<T> {
    return object : Iterable<T> {
        override fun iterator(): Iterator<T> = this@asIterable.iterator()
    }
}

/**
 * Returns the Iterable that wraps the original array
 */
public fun BooleanArray.asIterable(): Iterable<Boolean> {
    return object : Iterable<Boolean> {
        override fun iterator(): Iterator<Boolean> = this@asIterable.iterator()
    }
}

/**
 * Returns the Iterable that wraps the original array
 */
public fun ByteArray.asIterable(): Iterable<Byte> {
    return object : Iterable<Byte> {
        override fun iterator(): Iterator<Byte> = this@asIterable.iterator()
    }
}

/**
 * Returns the Iterable that wraps the original array
 */
public fun CharArray.asIterable(): Iterable<Char> {
    return object : Iterable<Char> {
        override fun iterator(): Iterator<Char> = this@asIterable.iterator()
    }
}

/**
 * Returns the Iterable that wraps the original array
 */
public fun DoubleArray.asIterable(): Iterable<Double> {
    return object : Iterable<Double> {
        override fun iterator(): Iterator<Double> = this@asIterable.iterator()
    }
}

/**
 * Returns the Iterable that wraps the original array
 */
public fun FloatArray.asIterable(): Iterable<Float> {
    return object : Iterable<Float> {
        override fun iterator(): Iterator<Float> = this@asIterable.iterator()
    }
}

/**
 * Returns the Iterable that wraps the original array
 */
public fun IntArray.asIterable(): Iterable<Int> {
    return object : Iterable<Int> {
        override fun iterator(): Iterator<Int> = this@asIterable.iterator()
    }
}

/**
 * Returns the Iterable that wraps the original array
 */
public fun LongArray.asIterable(): Iterable<Long> {
    return object : Iterable<Long> {
        override fun iterator(): Iterator<Long> = this@asIterable.iterator()
    }
}

/**
 * Returns the Iterable that wraps the original array
 */
public fun ShortArray.asIterable(): Iterable<Short> {
    return object : Iterable<Short> {
        override fun iterator(): Iterator<Short> = this@asIterable.iterator()
    }
}

/**
 * Returns the range of valid indices for the array
 */
public val <T> Array<out T>.indices: IntRange
    get() = IntRange(0, lastIndex)

/**
 * Returns the range of valid indices for the array
 */
public val BooleanArray.indices: IntRange
    get() = IntRange(0, lastIndex)

/**
 * Returns the range of valid indices for the array
 */
public val ByteArray.indices: IntRange
    get() = IntRange(0, lastIndex)

/**
 * Returns the range of valid indices for the array
 */
public val CharArray.indices: IntRange
    get() = IntRange(0, lastIndex)

/**
 * Returns the range of valid indices for the array
 */
public val DoubleArray.indices: IntRange
    get() = IntRange(0, lastIndex)

/**
 * Returns the range of valid indices for the array
 */
public val FloatArray.indices: IntRange
    get() = IntRange(0, lastIndex)

/**
 * Returns the range of valid indices for the array
 */
public val IntArray.indices: IntRange
    get() = IntRange(0, lastIndex)

/**
 * Returns the range of valid indices for the array
 */
public val LongArray.indices: IntRange
    get() = IntRange(0, lastIndex)

/**
 * Returns the range of valid indices for the array
 */
public val ShortArray.indices: IntRange
    get() = IntRange(0, lastIndex)

/**
 * Returns true if the array is empty
 */
public fun <T> Array<out T>.isEmpty(): Boolean {
    return size() == 0
}

/**
 * Returns true if the array is empty
 */
public fun BooleanArray.isEmpty(): Boolean {
    return size() == 0
}

/**
 * Returns true if the array is empty
 */
public fun ByteArray.isEmpty(): Boolean {
    return size() == 0
}

/**
 * Returns true if the array is empty
 */
public fun CharArray.isEmpty(): Boolean {
    return size() == 0
}

/**
 * Returns true if the array is empty
 */
public fun DoubleArray.isEmpty(): Boolean {
    return size() == 0
}

/**
 * Returns true if the array is empty
 */
public fun FloatArray.isEmpty(): Boolean {
    return size() == 0
}

/**
 * Returns true if the array is empty
 */
public fun IntArray.isEmpty(): Boolean {
    return size() == 0
}

/**
 * Returns true if the array is empty
 */
public fun LongArray.isEmpty(): Boolean {
    return size() == 0
}

/**
 * Returns true if the array is empty
 */
public fun ShortArray.isEmpty(): Boolean {
    return size() == 0
}

/**
 * Returns true if the array is not empty
 */
public fun <T> Array<out T>.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Returns true if the array is not empty
 */
public fun BooleanArray.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Returns true if the array is not empty
 */
public fun ByteArray.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Returns true if the array is not empty
 */
public fun CharArray.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Returns true if the array is not empty
 */
public fun DoubleArray.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Returns true if the array is not empty
 */
public fun FloatArray.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Returns true if the array is not empty
 */
public fun IntArray.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Returns true if the array is not empty
 */
public fun LongArray.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Returns true if the array is not empty
 */
public fun ShortArray.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Returns the last valid index for the array
 */
public val <T> Array<out T>.lastIndex: Int
    get() = size() - 1

/**
 * Returns the last valid index for the array
 */
public val BooleanArray.lastIndex: Int
    get() = size() - 1

/**
 * Returns the last valid index for the array
 */
public val ByteArray.lastIndex: Int
    get() = size() - 1

/**
 * Returns the last valid index for the array
 */
public val CharArray.lastIndex: Int
    get() = size() - 1

/**
 * Returns the last valid index for the array
 */
public val DoubleArray.lastIndex: Int
    get() = size() - 1

/**
 * Returns the last valid index for the array
 */
public val FloatArray.lastIndex: Int
    get() = size() - 1

/**
 * Returns the last valid index for the array
 */
public val IntArray.lastIndex: Int
    get() = size() - 1

/**
 * Returns the last valid index for the array
 */
public val LongArray.lastIndex: Int
    get() = size() - 1

/**
 * Returns the last valid index for the array
 */
public val ShortArray.lastIndex: Int
    get() = size() - 1

