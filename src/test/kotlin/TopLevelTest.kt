import io.kotlintest.specs.StringSpec


/**
 * 어떤 범위 (scope) 로 사용하는가에 따라 몇 가지 종류로 구분할 수 있다
 *
 * 파일에 바로 정의하는 것이 최상위 수준 (top level) 이라고 한다.
 *
 * 최상위 수준으로 정의하면 컴파일 이후에 자바 코드로 변경되었을 때
 * 클래스의 static 변수 혹은 함수로 바뀐다.
 */
class TopLevelTest : StringSpec() {
}

/**
 * val 을 붙이면 final 이 붙는데, var 이기에 붙지 않음
 *
 * private static
 * public static setCount
 * public static getCount
 */
var count = 0

/**
 * public static
 */
fun printCount(from: Int, to: Int) {
    for(i in from..to)
        count += i
}

/**
 * private static final
 * public static getTAB1
 */
val TAB1 = "\t"

/**
 * public static final
 *
 * const val 로 선언하면, 프로퍼티로 생성되는게 아니라 필드로 생성됨
 */
const val TAB2 = "\t"