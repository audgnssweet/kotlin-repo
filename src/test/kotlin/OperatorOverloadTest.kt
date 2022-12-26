import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * 사칙연산 및 나눗셈 오버로딩 뿐
 */
class OperatorOverloadTest : StringSpec() {

    data class Score(val a: Int, val b: Int) {
        operator fun plus(other: Score): Score {
            return Score(a + other.a, b + other.b)
        }

        operator fun times(other: Score): Score {
            return Score(a * other.a, b * other.b)
        }

        operator fun div(other: Score): Score {
            return Score(a / other.a, b / other.b)
        }

        operator fun rem(other: Score): Score {
            return Score(a % other.a, b % other.b)
        }
    }

    //확장 함수
    operator fun Score.minus(other: Score): Score {
        return Score(a - other.a, b - other.b)
    }

    init {
        "덧셈 오버라이딩" {
            val s1 = Score(100, 100)
            val s2 = Score(200, 200)

            val res = s1 + s2

            res.a shouldBe 300
            res.b shouldBe 300
        }

        "확장 함수를 사용한 뺄셈 오버라이딩" {
            val s1 = Score(100, 100)
            val s2 = Score(200, 200)

            val res = s1 - s2

            res.a shouldBe -100
            res.b shouldBe -100
        }

        "곱셈 오버라이딩" {
            val s1 = Score(100, 100)
            val s2 = Score(200, 200)

            val res = s1 * s2

            res.a shouldBe 20000
            res.b shouldBe 20000
        }

        "나눗셈 오버라이딩" {
            val s1 = Score(100, 100)
            val s2 = Score(20, 20)

            val res = s1 / s2

            res.a shouldBe 5
            res.b shouldBe 5
        }

        "나머지 연산 오버라이딩" {
            val s1 = Score(100, 100)
            val s2 = Score(99, 98)

            val res = s1 % s2

            res.a shouldBe 1
            res.b shouldBe 2
        }
    }
}