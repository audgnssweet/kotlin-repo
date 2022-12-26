import io.kotlintest.specs.StringSpec

class LateInitTest : StringSpec() {

    lateinit var a: String

    init {
        "" {
            var a: String
        }
    }

}

/**
 * 클래스 인스턴스를 초기화 하는 시점 혹은
 * 최상위 프로퍼티 선언할 때
 * 외부 프레임워크가 값을 초기화 해줘야한다던가 할 때가 있다
 *
 * 이럴 때 사용하는 키워드가 lateinit 이다.
 *
 * 원래 코틀린에서는 지역변수 제외하고 "프로퍼티" 로 선언 되는 부분
 * 즉 최상위 선언 혹은 클래스의 프로퍼티 (단 주생성자에 선언하는 것 제외. 주생성자에 선언하면 무조건 값을 받는 것이기 때문에)
 * 에는 무조건 값을 초기화 해줘야 한다.
 * 물론 지역변수에도 사용이 가능하다.
 *
 * 하지만 위에 언급한 경우에는 lateinit 을 쓰는게
 * nullable type 으로 null 선 초기화보다 훨씬 좋은 방법이다 -> null 체크 매번 해줘야함..
 *
 * 안되는 경우
 * 1. primitive type 은 안됨
 * 2. nullable type 은 안됨
 * 3. var 이 아닌 경우는 안됨
 * 4. custom 접근자 정의 안됨
 *
 */

class Person
lateinit var a: Person

class Student {
    lateinit var name: String
}

class Professor(var name: String)

// lateinit var b: Int //컴파일 에러