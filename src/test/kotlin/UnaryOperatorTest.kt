import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class UnaryOperatorTest : StringSpec() {


    data class Score(val a: Int, val b: Int)
    operator fun Score.unaryMinus() = Score(-a, -b)

    init {
        "+ 단항 연산자" {
            val a = -20
            val res = -a

            res shouldBe 20
        }

        "단항 연산자 오버라이딩" {
            val score = Score(10, 10)

            val res = -score

            res.a shouldBe -10
            res.b shouldBe -10
        }
    }
}