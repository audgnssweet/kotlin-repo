import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class SafeCallOperatorTest : StringSpec() {

    /**
     * safe call 연산자 사용시, null 인 경우 그냥 null 을 반환한다.
     */
    init {
        "if 를 대신해준다" {
            val a: String? = null

            val b = if(a != null) a.length else null
            val c = a?.length

            b shouldBe null
            c shouldBe null

            b shouldBe c
        }

        "연쇄 호출이 가능하다" {
            var a: String? = "코틀린을 배우자"

            a?.substring(5)?.length shouldBe 3
        }
    }
}