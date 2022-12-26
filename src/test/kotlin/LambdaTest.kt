class LambdaTest {
}

/**
 * 람다는
 *
 * { 인자: 타입 -> 실행 코드 }
 * 로 나타낸다.
 *
 * 람다에서는 지역변수 혹은 프로퍼티를 바로 사용할 수 있다.
 */

fun lambdaTest() {
    val a = { 7 } //인자가 없고 반환이 7 인 람다식 () -> Int

    println(run { 7 })
    println({ 7 }())

    val v1 = 100
    val v2: () -> Int = { v1 + 7 }
    println(v2())
}

val v1 = 100
val v2: () -> Int = { v1 + 7 }