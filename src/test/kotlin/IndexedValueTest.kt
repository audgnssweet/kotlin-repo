import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * IndexedValue 는 코틀린의 데이터 클래스이다.
 */
class IndexedValueTest : StringSpec() {

    init {
        "use" {
            val iv = IndexedValue(1, "hi")
            iv.index shouldBe 1
            iv.value shouldBe "hi"
        }

        "use with collection" {
            val l = listOf(1, 2, 3, 4, 5)
            val withIndex = l.withIndex()

            for (iv in withIndex) {
                iv.index
                iv.value
            }

            withIndex.filter { (i, _) -> i % 2 == 0 }
            withIndex.filter { it.index % 2 == 0 }
        }

        "use" {
            val ls = listOf("홍길동", "김선달", "황진이", "전신주", "황토길")
            ls.withIndex().filter { it.index > 2 && it.value.startsWith("황") }
            val filterIndexed = ls.filterIndexed { idx, _ -> idx % 2 == 0 } // 결과에서는 index 가 빠져있음

            ls.mapIndexed { index, _ -> index + 1 }

            ls.forEachIndexed { index, value -> println("index = $index, value = $value") }
        }
    }
}