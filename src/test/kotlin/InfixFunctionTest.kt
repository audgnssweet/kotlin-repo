import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class InfixFunctionTest : StringSpec() {

    data class Score(val a: Int, val b: Int)

    /**
     * 중위(infix) 함수
     * 투 피연산자 사이에 연산자처럼 넣어서 호출할 수 있는 함수
     *
     * 1. 클래스의 멤버 혹은 확장함수
     * 2. 매개변수가 반드시 한개
     * 3. infix 키워드 사용해야함
     */
    infix fun Score.times(other: Score): Score {
        return Score(a * other.a, b * other.b)
    }

    init {
        "중위함수 사용" {
            val s1 = Score(10, 10)
            val s2 = Score(20, 30)

            s1.times(s2) shouldBe Score(200, 300)
            (s1 times s2) shouldBe Score(200, 300)
        }
    }
}