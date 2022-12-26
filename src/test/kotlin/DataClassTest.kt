import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class DataClassTest : StringSpec() {

    init {
        "use" {
            val f1 = Friend("김선달", 30, "010-1234-1234")
            val f2 = Friend("김선달", 31, "010-1234-1234")
            val f3 = Friend("김선달", 30, "010-1234-1234")

            (f1 == f2) shouldBe false
            (f1 == f3) shouldBe true

            (f1.hashCode() == f2.hashCode()) shouldBe false
            f1.hashCode() shouldBe f3.hashCode()

            val f4 = f2.copy(tel = "1234")

            f4.tel shouldBe "1234"
        }

        "해체 선언" {
            val f1 = Friend("김선달", 30, "010-1234-1234")

            f1.component1() shouldBe "김선달"
            f1.component2() shouldBe 30
            f1.component3() shouldBe "010-1234-1234"

            val (name, age, tel) = f1
            name shouldBe "김선달"
            age shouldBe 30
            tel shouldBe "010-1234-1234"

            //원치 않는 속성은 언더바로 가려낼 수 있음
            val (name2, _, tel2) = f1
            name2 shouldBe "김선달"
            tel2 shouldBe "010-1234-1234"
        }
    }
}

/**
 * 주로 데이터를 운반하는 클래스들
 *
 * 인스턴스 속성 비교 (equals)
 * 컬렉션에 저장할 때 사용할 키값 (hash code)
 * 문자열로 출력하는 기능 (to string)
 * 값이 동일한 인스턴스를 생성하는 기능 (copy)
 * 해체 선언 (componentN)
 *
 * 을 자동으로 만들어준다.
 */
data class Friend(val name: String, val age: Int, val tel: String)

