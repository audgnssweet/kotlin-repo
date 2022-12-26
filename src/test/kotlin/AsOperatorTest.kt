import io.kotlintest.shouldBe
import io.kotlintest.shouldNotThrowAny
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

class AsOperatorTest : StringSpec() {

    init {

        "as 사용해보기" {
            val s1 = 100
            var s2: String?

//            s2 = s1 // 컴파일 에러

            var s3: Any = "abc"
            s2 = s3 as String

            s2 shouldBe "abc"
        }

        "as exception 확인하기" {
            shouldThrow<ClassCastException> { "123" as Int }
        }

        "as? 사용하기" {
            val s1 = 100
            var s2: String?

            s2 = s1 as? String?

            s2 shouldBe null
        }

        "as? exception 던지지 않고 null 반환하는 것 확인" {
            shouldNotThrowAny { "123" as? Int }
        }
    }
}