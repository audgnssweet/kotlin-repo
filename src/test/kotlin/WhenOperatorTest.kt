import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class WhenOperatorTest : StringSpec() {

    init {
        "case 1" {
            val input = 1

            when(input) {
                1 -> println("1 입니다")
                2, 3 -> println("2 or 3 입니다")
                else -> println("모름")
            }
        }

        fun checkInput(input: Int): Int {
            return if ((input >= 1) and (input < 3)) return input else -1
        }

        "case 2" {
            val input = 4

            when(input) {
                checkInput(input) -> println("타입 정상")
                else -> println("타입 비정상")
            }
        }

        "case 3" {
            val start = 0
            val end = 100

            val score = 50

            when(score) {
                in start .. (end / 4) -> println("우수함")
                50 -> println("평균임")
                in start .. end -> println("범위에 있음")
                else -> println("범위를 벗어남")
            }
        }

        "case 4" {
            val city = "서울"

            val isSeoul = when(city) {
                is String -> city.startsWith("서울")
                else -> false
            }

            isSeoul shouldBe true
        }

        "case 5" {
            val city = "서울"

            when {
                city.length == 0 -> println("도시를 입력하세요")
                city.substring(0, 2) == "서울" -> println("서울이군요")
                else -> println(city)
            }
        }
    }
}