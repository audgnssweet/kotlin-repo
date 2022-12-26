import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class IsOperatorTest : StringSpec() {

    open class A
    class B : A()

    init {
        "상속 관계에서 is 사용해보기" {
            val x = B()

            (x is A) shouldBe true
            (x !is A) shouldBe false
            (x is B) shouldBe true
            (x !is B) shouldBe false
        }
    }
}