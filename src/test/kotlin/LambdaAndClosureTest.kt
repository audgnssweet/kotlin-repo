import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class LambdaAndClosureTest : StringSpec() {

    init {

        /**
         * 함수형 프로그래밍에서
         * 다른 함수에 포함된 함수에서, 자신을 포함한 함수의 매개변수와 변수를 사용할 수 있는 것을
         * 클로저 (closure) 라고 한다.
         *
         * 외부 변수 혹은 매개변수가 val 이면 값이 그대로 저장되고
         * var 이면 그 값이 별도의 객체로 저장되어 참조한다.
         */
        "closure" {

            fun calcTotal(from: Int, to: Int): Int {
                var total: Int = 0

                val lambda = { f: Int, t: Int ->
                    for (i in f..t) {
                        total += i
                    }

                    total
                }

                lambda(from, to)

                return total
            }

            calcTotal(1, 10) shouldBe 55

        }
    }
}