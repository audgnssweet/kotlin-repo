import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ObjectDeclarationTest : StringSpec() {

    init {

        "객체 선언 사용해보기" {
            StateManager.msgNumber shouldBe 0
            StateManager.msgContent shouldBe ""

            StateManager.storeMessage()
        }

        "이너 오브젝트 사용해보기" {
            Outer.InnerObject.printCount()
        }
    }
}

/**
 * 싱글턴 객체 보장
 * 객체 이름으로 바로접근
 *
 * 속성과 함수 및 초기화 블록도 포함 가능하다
 * 단, 생성자는 안됨. 어차피 못쓰니까
 */
object StateManager : CaptureMessage {
    var msgNumber: Int = 0
    var msgContent: String = ""

    init {
        //init
    }

    fun storeMessage() = println("번호 = $msgNumber , 내용 = $msgContent")

    //클래스나 인터페이스를 상속받아 구현하는 것도 가능하다.
    override fun capture() {
        TODO("Not yet implemented")
    }
}

interface CaptureMessage {
    fun capture()
}

class Outer private constructor() {

    private val name: String = ""

    fun p() = println("hi")

    /**
     * 클래스 내부에 inner object 로도 생성이 가능하다.
     *
     * Outer 는 싱글턴이 아니지만 Inner 는 싱글턴을 보장한다.
     * 그리고 Outer.Inner. 으로 참조한다.
     *
     * Outer 인스턴스를 생성하지 않아도 호출 가능
     *
     * 싱글턴 + static 이기 때문에, outer 클래스의 프로퍼티나 멤버함수에 접근이 불가능하다
     */
    object InnerObject {
        var count: Int = 0
        fun printCount() {
            println(count)
//            p() //접근이 불가능하다.
        }
    }
}