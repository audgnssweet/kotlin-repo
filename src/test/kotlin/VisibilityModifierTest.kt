import io.kotlintest.specs.StringSpec

class VisibilityModifierTest : StringSpec() {
}

/**
 * 최상위 수준 요소
 * 클래스, 인터페이스, 함수, 객체(object), 속성, 확장(함수와 속성)
 */

/**
 * private
 * 최상위 : 해당 파일
 * 클래스 : 클래스 내부에서만
 *
 * protected
 * 최상위 : 사용하지 않음
 * 클래스 : 클래스 내부, 상속받은 클래스에서만 (단, 자바와 달리 패키지 아님)
 *
 * internal
 * 최상위 : 같은 모듈 내에서만 사용 (같은 프로젝트)
 *
 * public
 * 특별히 가시성 제한자를 지정해주지 않으면 public 으로, 어디에서든 사용 가능하다
 */


//public 생략 가능
public val accessAll: String = "어디서든 사용 가능"

internal class MyFriend5(protected var name: String) {
    fun findName(name: String) = println()
    private fun myFun(): Unit {}
}

private fun printPrivate() {}
