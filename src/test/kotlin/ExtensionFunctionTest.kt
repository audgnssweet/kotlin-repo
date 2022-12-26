import io.kotlintest.matchers.collections.shouldContainExactly
import io.kotlintest.specs.StringSpec

class ExtensionFunctionTest : StringSpec() {

    init {

        /**
         * 확장함수의 type 을 수신자라고 하고,
         * T 는 수신자의 타입 매개변수
         *
         * this 는 수신자 인스턴스를 의미한다
         */
        fun <T> MutableList<T>.swap(idx1: Int, idx2: Int) {
            val tmp = this[idx1]
            this[idx1] = this[idx2]
            this[idx2] = tmp
        }

        "확장 함수 사용해보기" {
            val list = mutableListOf(1, 2, 3)
            list.swap(0, 2)

            list shouldContainExactly listOf(3, 2, 1)
        }
    }
}