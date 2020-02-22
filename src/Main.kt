fun rangeExtraction(arr: IntArray): String {
    val builder = StringBuilder()
    val queue = mutableListOf<Int>()
    var prev = -1
    var first = true

    arr.forEach { value ->
        run {
            if (first) {
                builder.append("$value")
                first = false
            } else if (value - prev == 1) {
                queue.add(value)
            } else {
                if (queue.size == 1) {
                    builder.append(",$prev")
                    queue.clear()
                } else if (queue.size > 1) {
                    builder.append("-$prev")
                    queue.clear()
                }

                builder.append(",$value")
            }

            prev = value
        }
    }

    if (queue.size == 1) {
        builder.append(",$prev")
        queue.clear()
    } else if (queue.size > 1) {
        builder.append("-$prev")
        queue.clear()
    }

    return builder.toString()
}

fun main() {
    println(rangeExtraction(intArrayOf(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20)))
}