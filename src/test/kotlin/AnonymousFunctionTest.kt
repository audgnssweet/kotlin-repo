import io.kotlintest.specs.StringSpec

class AnonymousFunctionTest : StringSpec() {

    /**
     * 실행 가능한 코드 블록을 전달할 때 람다식 외에도 익명 함수를 사용 가능
     *
     * 보통 람다식과 익명함수는 서로 대체 가능하다.
     *
     * 익명 함수의 매개변수는 반드시 괄호 안에 지정
     * 익명 함수는 언제든지 return 으로 종료 가능하다.
     *
     * 익명함수도 마찬가지로 closure 이다.
     */
    init {
        data class Friend(val name: String, val age: Int)

        "" {
            val fList = listOf(Friend("lee", 10), Friend("kim", 20))

            fList.filter(fun(friend) = friend.age >= 30)

            fList.filter(
                fun(friend): Boolean {
                    return friend.age >= 30
                }
            )

            //익명 함수의 클로저 성질을 맛볼 수 있다
            val k = 100
            val l = listOf(1, 2, 3, 4, 5)

            l.map(fun(it) = it + k)
        }
    }
}