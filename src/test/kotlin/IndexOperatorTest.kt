import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class IndexOperatorTest : StringSpec() {

    /**
     * 인덱스 연산자는 컴파일러에 의해 get, set 으로 자동 대체된다.
     */
    init {

        "get" {
            val arr = arrayOf(1, 2, 3, 4)
//            arr[5] = 300 //여기서 오류 발생

            arr[0] shouldBe 1

            val map = mutableMapOf<String, Int>()
            map["kim"] = 100
            map["lee"] = 200

            map["kim"] shouldBe 100
        }

    }
}