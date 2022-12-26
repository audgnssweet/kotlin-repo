import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * sealed class 는 서브 클래스의 종류를 제한하기 위해서 사용한다.
 *
 * 어찌보면 enum class 와 비슷한 경향이 있다.
 */
class SealedTest : StringSpec() {

    init {
        "use" {
            FriendType.School("숭실대", 0).name shouldBe "숭실대"

            Major()
        }
    }
}

//아래처럼 FriendType 내부에 선언 가능하다
sealed class FriendType {
    class School(val name: String, val schoolType: Int) : FriendType()
    class Sns : FriendType()
}

//아래처럼 CompanyType 외부에 선언 가능하다
//사용하는 방식은 위의 예제를 참고하자
sealed class CompanyType
class Major : CompanyType()
class Midsize : CompanyType()