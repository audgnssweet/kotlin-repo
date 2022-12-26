import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class Dimension2ArrayTest : StringSpec() {

    fun createArray(row: Int, col: Int): Array<Array<Int>> {
        val newArray = Array(row) { Array(col) { 0 } }

        var rowValue = 1
        for (y in 0 until row) {
            for (x in 0 until col) {
                newArray[y][x] = rowValue + x
            }
            rowValue += 10
        }
        return newArray
    }

    fun printArray(arr: Array<Array<Int>>) {
        for (y in 0 until arr.size) {
            for (x in 0 until arr[y].size) {
                print("${arr[y][x]} ")
            }
            println()
        }
    }

    init {
        "2차원 배열 만들기" {
            val arr = createArray(5, 5)

            printArray(arr)

            arr.size shouldBe 5
            arr[0].size shouldBe 5
        }
    }
}