import io.kotlintest.specs.StringSpec

class MemberReferenceAndTopFunctionReferenceTest : StringSpec() {

    init {
        data class Friend(val name: String, val age: Int)

        "멤버 참조 (속성, 함수 전부 다)" {
            val fList = listOf(Friend("kim", 25), Friend("lee", 25))

            fList.filter { it.age >= 20 }
                .map { Friend::name }

            fun Friend.isOld() = age >= 30

//            fList.filter { Friend::isOld } //이렇게 사용하는 것은 불가능하다. 아래처럼 사용해야 한다.
            // 코틀린의 람다에서는 아직 멤버 함수에 대한 참조를 위처럼 사용하는 것을 허용하지 않고 있다.
            fList.filter { (Friend::isOld)(it) }
                .map { Friend::name }

            //하지만 아래처럼 사용하는 것은 가능하다
            fList.filter(Friend::isOld)
                .map { Friend::name }

            val checkAge = Friend::isOld

            //이것도 위와 마찬가지인데, 아마 아래 두 개 중 위 방식으로 사용하는게 나을 것 같다.
            fList.filter(checkAge)
            fList.filter { checkAge(it) }

            //아래처럼 생성자를 집어넣고 사용하는 것도 가능하다
            val create = ::Friend
            val friend = create("jeong", 1)
        }

        "최상위 수준 함수 참조" {
            run(::hello)
            val h = ::hello
            h()
            run(h)
        }
    }
}

fun hello() = println("안녕하세요!!")