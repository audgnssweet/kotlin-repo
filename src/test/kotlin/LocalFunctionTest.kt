import io.kotlintest.specs.StringSpec

class LocalFunctionTest : StringSpec() {
}

/**
 * 코틀린에서는 함수 내부에 또다른 함수를 정의해서 사용할 수 있다
 *
 * 지역 함수는 자신을 포함하는 함수의 인자나 변수를 그냥 사용할 수 있다.
 */
fun calcCombination(whole: Int, selected: Int): Double {
    fun calcFactorial(num: Int): Double {
        var total: Double = 1.0
        for (i in num downTo 1) {
            total *= i
        }

        return total
    }

    if ((selected > whole) || (selected <= 0) || (whole <= 0)) {
        return -1.0
    } else if (selected == whole) {
        return 1.0
    }

    return calcFactorial(whole) / (calcFactorial(whole - selected) * calcFactorial(selected))
}