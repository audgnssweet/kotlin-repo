import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.time.LocalDate

class RangeOperatorTest : StringSpec() {

    /**
     * .. 은 시작값과 끝값이 필요하며,
     * 시작값과 끝값은 동일 타입이면서 끝값이 시작값보다 같거나 커야한다.
     */
    init {

        "범위 연산자의 타입 체크" {
            val r1 = 'a'..'z'
            val r2 = 1..100

            r1.javaClass shouldBe CharRange::class.java
            r2.javaClass shouldBe IntRange::class.java
        }

        "범위 연산자와 in 연산자의 결합" {
            val r1 = 'a'..'z'
            val r2 = 1..100

            ('b' in r1) shouldBe true
            (55 in r2) shouldBe true
        }

        "범위 연산자와 for 문의 결합" {
            for (i in 1..7) {
                println(i)
            }
        }

        "Date 에도 범위 연산자를 사용 가능하다" {
            val start = LocalDate.now()
            val end = start.plusDays(15)

            val range = start..end

            (LocalDate.now().plusDays(5) in range) shouldBe true
            (LocalDate.now().plusDays(20) in range) shouldBe false
        }
    }
}