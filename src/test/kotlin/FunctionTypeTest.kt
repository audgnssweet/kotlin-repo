class FunctionTypeTest {
}

/**
 * 함수 타입 (Function Type)
 * 함수형 프로그래밍에서는 변수나 객체처럼 함수도 type 을 가질 수 있다.
 *
 * val sum: (Int, Int) -> Int = { x, y -> x + y }
 * 에서 (Int, Int) -> Int 가 함수의 type 이다.
 *
 * (Int) -> Int
 * () -> Int
 * (Int) -> Unit
 *
 * 람다를 인자로 받아서 Int 를 반환
 * fun exec(lambda: (Int, Int) -> Int): Int
 *
 * 람다를 인자로 받아서 람다를 반환
 * fun execAndReturnLambda(lambda: (int, Int) -> Int): (Int) -> Int
 *
 * 위처럼 람다를 인자로 받는 함수를 고차함수라고 한다.
 *
 * fun exec(lambda: (Int, Int) -> Int -> Int): (Int) -> Int
 * 위쪽의 exec 같은 함수를 인자로 받아서 람다를 반환하는 함수라는 뜻이다.
 */

//고차함수 예시
fun exec(lambda: (Int, Int) -> Int): Int {
    lambda.invoke(1, 2)
    return lambda(1, 2)
}

//고차함수 예시
fun exec(lambda: ((Int, Int) -> Int) -> Int): Int {
    return lambda { x, y -> x + y }
}

/**
 * 람다는 일급 객체이므로, 컬렉션의 인자로도 쓰일 수 있음
 */
fun collection(): Int {
    val list: ArrayList<(Int, Int) -> Int> = ArrayList()
    list.add { x, y -> x + y }

    return list.first()(1, 2)
}