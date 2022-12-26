import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AssertionOperatorTest : StringSpec() {

    init {

        /**
         * 왜 필요한가?
         * 컴파일러가 null 발생을 미리 알 수 없는 상황
         * nullable 변수가 null 인지 아닌지 한 함수에서 확인하고 계속 돌려쓰는 경우나
         * 혹은 런타임에 시스템 라이브러리 변수 참조할 때 언제 발생할지 모르는 NPE 를 파악할 때 필요
         */
        "단언 연산자 사용해보기" {
            var a : String? = "코틀린을 배우자"

            val b = a!!.length

            b shouldBe 8
        }
    }
}