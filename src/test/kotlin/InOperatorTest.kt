import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class InOperatorTest : StringSpec() {

    init {
        "in 정상 동작 확인" {
            val arr = arrayOf(1, 2, 3, 4)

            (1 in arr) shouldBe true
            (5 in arr) shouldBe false

            (1 !in arr) shouldBe false
            (5 !in arr) shouldBe true
        }
    }
}