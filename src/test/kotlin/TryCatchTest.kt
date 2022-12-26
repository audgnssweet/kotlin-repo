import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class TryCatchTest : StringSpec() {

    init {
        "try catch 는 표현식으로 쓰일 수 있다" {
            val res = try {
                "abc".toInt()
            } catch (e: Exception) {
                null
            }

            res shouldBe null
        }

        "exception 발생의 type 은 Nothing 이다" {
            fun fail(message: String): Nothing {
                throw RuntimeException(message)
            }
        }
    }
}