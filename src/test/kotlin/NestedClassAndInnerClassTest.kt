import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class NestedClassAndInnerClassTest : StringSpec() {

    init {
        "using" {
            Outer.Nested().funcNested() shouldBe 2
            Outer().Inner().funcInner() shouldBe 1
        }
    }

    /**
     * 중첩 클래스는 그냥 class 로 선언하고 슈퍼 클래스의 멤버 함수와 속성 사용 불가
     * inner class 는 inner class 로 선언하고 슈퍼 클래스의 멤버 함수와 속성 사용 가능
     *
     * 중첩 클래스는 슈퍼 클래스의 이름만 빌리면 생성 가능하나,
     * inner class 는 슈퍼 클래스의 인스턴스가 있어야 한다.
     */
    class Outer {
        private val bar: Int = 1

        class Nested {
            fun funcNested() = 2
        }

        inner class Inner {
            fun funcInner() = bar
        }
    }
}

