import io.kotlintest.specs.StringSpec

class TailRecursiveFunctionTest : StringSpec() {

    fun calcFactorial(num: Double): Double = if (num == 1.0) 1.0 else num * calcFactorial(num - 1)

    /**
     * 꼬리형 재귀함수
     * 마지막이 반드시 자신을 호출하는 것으로 끝나야함. 자신 호출 말고 이후 연산 (예를들어 그 값을 곱셈) 하면 안됨
     */
    tailrec fun calcFactorial2(num: Double, total: Double = 1.0): Double =
        if (num == 1.0) total else calcFactorial2(num - 1, num * total)
}