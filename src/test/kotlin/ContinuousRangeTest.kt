import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ContinuousRangeTest : StringSpec() {

    /**
     * 연속 범위값도 Iterable 을 구현하기 때문에 컬렉션처럼 사용이 가능하다.
     */
    init {
        "1" {
            val range = IntRange(1, 10)
            val range2 = 1..10
        }

        "2" {
            (1..10).forEach { println(it) }
        }

        "3" {
            (1..10).first
            (1..10).last
            (1..10).step shouldBe 1
            (1..10 step 2).step shouldBe 2
        }

        "4" {
            (1..10).isEmpty() shouldBe false
            (1..10).none() shouldBe false
        }

        "5" {
            (1..10).contains(5) shouldBe true
        }

        "6" {
            (1..10).elementAtOrNull(15) shouldBe null
        }

        "7" {
            (1..10).count() shouldBe 10
            (1..10).count { it % 2 == 0 } shouldBe 5
            (1..10).max() shouldBe 10
            (1..10).min() shouldBe 1
            (1..10).sum() shouldBe 55
            (1..10).average() shouldBe 5.5
        }

        "8" {
            println((1..10).joinToString(","))
        }

        "9" {
            (1..10).toSet()
        }
    }
}