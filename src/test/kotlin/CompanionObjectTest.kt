import io.kotlintest.specs.StringSpec

class CompanionObjectTest : StringSpec() {

    init {
        "동반 객체 사용" {
            OuterClass.printMsg()
        }
    }
}

/**
 * 마찬가지로 companion object 의 싱글턴을 보장한다.
 * 하지만 일반 내부 Object 선언과의 차이점은
 * companion object 의 이름을 직접 참조하지 않아도 된다는 점이다.
 *
 * Outer. 으로 접근이 가능하다.
 * 그래서 마치 java 의 static 처럼 사용할 수 있다
 *
 * 주로 static 하게 접근하는 팩토리 메서드라던가 그런 곳에 활용 가능하다
 *
 * 동반 객체의 이름은 생략할수도 넣을수도 있다
 */
class OuterClass {
    private constructor()

    companion object {
        fun printMsg() {
            println("동반 객체 함수 호출")
        }

        //팩토리 메서드
        fun create() = OuterClass()
    }
}