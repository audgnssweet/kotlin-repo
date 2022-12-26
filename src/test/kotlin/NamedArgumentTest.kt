import io.kotlintest.specs.StringSpec

class NamedArgumentTest : StringSpec() {

    /**
     * 지명 인자 (named argument)
     * 파라미터 기본값을 정의할 수 있다.
     *
     * 하지만 자바 함수를 직접 호출하면 인자를 직접 지정할 수 없다
     */
    fun min(valueLeft: Int = 0, valueRight: Int = 0) = if (valueLeft < valueRight) valueLeft else valueRight

    init {
        "사용한다" {
            min(100, 50)
            min(100)
            min()
            min(valueLeft = 50, valueRight = 100)
            min(valueRight = 100, valueLeft = 50)
            min(valueRight = 100)
        }
    }
}