import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class EqualsTest : StringSpec() {

    init {

        data class Person(val name: String)

        "동일비교" {
            val p1 = Person("kim")
            val p2 = Person("kim")

            val res = p1 === p2

            res shouldBe false
        }

        "동등비교" {
            val p1 = Person("kim")
            val p2 = Person("kim")

            val res = p1 == p2

            res shouldBe true
        }
    }
}