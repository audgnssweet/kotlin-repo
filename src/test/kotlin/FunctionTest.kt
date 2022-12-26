import io.kotlintest.specs.StringSpec

class FunctionTest : StringSpec() {

    fun min(valueLeft: Int, valueRight: Int): Int {
        return if (valueLeft < valueRight) valueLeft else valueRight
    }

    fun min2(valueLeft: Int, valueRight: Int) = if (valueLeft < valueRight) valueLeft else valueRight

    /**
     * return 이 없으면 Unit 으로 자동으로 대체된다.
     * 마치 자바의 void 와 같다.
     * Unit 은 코틀린에서 싱글턴 객체로 관리되며,
     * 어찌됐든 return 이 된다.
     *
     * 하지만 내부에서 throw 같은걸 하게되어 return 하지 못하면
     * Nothing type 으로 return type 이 설정되게 된다.
     */
    fun returnUnit(): Unit {
        println()
    }

    fun returnNothing(): Nothing = throw IllegalArgumentException()

    init {

        "" {

        }
    }
}