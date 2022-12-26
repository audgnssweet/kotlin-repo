import io.kotlintest.specs.StringSpec

class InlineFunctionTest : StringSpec() {

    /**
     * 인라인 함수
     *
     * 함수를 호출하는 코드를 컴파일 타임에 해당 함수의 실행 코드로 대체해서 끼워넣는 것.
     * 컴파일된 바이트 코드의 크기는 약간 커지지만 코드의 실행 속도는 빨라진다.
     *
     * 코틀린에서는 람다식, 익명함수, 고차함수를 인라인 형태로 사용하는 경우가 많다.
     *
     * 고차 함수를 사용할 때는 런타임에 단점이 생길 수 있다.
     * 인자로 받은 람다식이나 익명 함수가 인스턴스로 생성되어 동작하므로 메모리 할당과 사용 및 호출로 시스템에 부담이 생기기 때문이다.
     *
     * 인라인은 로컬 함수에는 사용할 수 없는 키워드이다.
     *
     * 고차함수의 실행 성능을 높이기 위해 사용
     */
    init {

    }

    /**
     * 고차함수가 인라인 함수로 선언되면, 컴파일 시점에 바이트 코드로 갈아 끼워지기 때문에 아래와 같은 코드가 불가능하다.
     * 예를 들어서 람다를 다른 변수에 할당 (원래 되는건데 여기선 안됨)
     * 예를 들어서 람다를 반환 (원래 되는건데 여기선 안됨)
     */
//    inline fun calc(n1: Int, n2: Int, lambda: (Int, Int) -> Int) : Int {
//        val a = lambda
//        calc2(n1, n2, lambda)
//
//        return lambda
//    }

    //람다식 혹은 익명 함수를 인라인화 하고싶지 않으면 noinline 키워드를 붙여주면 된다.
    inline fun calc2(n1: Int, n2: Int, noinline lambda: (Int, Int) -> Int) = lambda(n1, n2)
}
