import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class HigherOrderFunctionTest : StringSpec() {

    /**
     * 고차 함수 -> 일급 객체인 함수 혹은 람다를 인자로 받거나 반환할 수 있는 함수를 의미한다.
     */
    init {

        fun calc(n1: Int, n2: Int, lambda: (Int, Int) -> Int): Int = lambda(n1, n2)

        "hi" {
            calc(1, 2) { x, y -> x + y } shouldBe 3
            calc(1, 2) { x, y -> x - y } shouldBe -1
        }

    }
}