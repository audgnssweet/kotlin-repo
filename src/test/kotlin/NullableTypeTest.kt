import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class NullableTypeTest : StringSpec() {

    /**
     * 코틀린의 모든 type 은 Any? 를 상속받음
     * 그리고 nullable - non-nullable 따로 상속 구조를 가진다.
     *
     * 하지만 컴파일 이후에는 자바 코드로 변경되는데,
     * 자바에는 nullable non-nullable type 구분이 없다.
     *
     * 그래서 이같은 nullable type 구분은 컴파일 시점에만 유효하다.
     */
    init {
        val a : String = "abc"
        val b : String? = null

        a.length shouldBe 3

        //null 체크에 의한 스마트 캐스팅
        val blen = if(b != null) b.length else 0

        blen shouldBe 0
    }
}