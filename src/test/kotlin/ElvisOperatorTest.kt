import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import java.lang.IllegalArgumentException

class ElvisOperatorTest : StringSpec() {

    init {

        "elvis 사용하기" {
            var a: String? = "코틀린을 배우자"

            val b = a?.length ?: 0

            b shouldBe 8
        }

        "elvis 사용하기 2" {
            var a: String? = null

            val b = a?.length ?: 0

            b shouldBe 0
        }

        fun elvis(a: String?): Int {
            return a?.length ?: 0
        }

        "elvis 사용하기 3" {
            elvis("abc") shouldBe 3
            elvis(null) shouldBe 0
        }

        fun elvis2(a: String?): Int {
            return a?.length ?: throw IllegalArgumentException()
        }

        "elvis 사용하기 4" {
            shouldThrow<IllegalArgumentException> { elvis2(null) }
        }
    }
}