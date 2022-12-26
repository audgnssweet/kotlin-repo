import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class IfOperatorTest : StringSpec() {

    /**
     * 코틀린에서 if 와 when 은 명령문이 아니라 표현식이다.
     */
    init {

        "if 표현식으로 바로 대입" {
            val y = 100

            val msg = if(y == 100) "y 는 100 이다" else "y 는 100이 아니다"

            msg shouldBe "y 는 100 이다"
        }

    }
}