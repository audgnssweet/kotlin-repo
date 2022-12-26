import io.kotlintest.specs.StringSpec

class AccessModifierTest : StringSpec() {


}

/**
 * 클래스와 클래스 멤버에만 사용할 수 있는 접근 제한자들
 *
 * final
 * 클래스 : 상속 불가
 * 멤버 : 오버라이딩 불가 (프로퍼티, 함수 다)
 *
 * open
 * 클래스 : 상속 가능
 * 멤버 : 오러바이딩 가능
 *
 * abstract
 * 클래스 : 추상 클래스로 만듦
 * 추상 클래스의 멤버는 기본적으로 open
 *
 * override
 * 멤버 : 서브 클래스에서 오버라이딩 할 때
 * 오버라이딩 시에는 기본적으로 public 가시성 제한자로 바뀜
 *
 * 인터페이스의 멤버들은 기본적으로 open abstract 이다.
 */

final class Person2
open class Person3
abstract class Person4
interface AutoClosable