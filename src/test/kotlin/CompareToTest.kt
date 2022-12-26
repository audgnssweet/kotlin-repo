import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CompareToTest : StringSpec() {

    init {
        class Person(val name: String, val phone: String) : Comparable<Person> {
            override fun compareTo(other: Person): Int {
                return compareValuesBy(this, other, Person::name, Person::phone)
            }
        }

        "이름으로 정상적으로 비교되는지 화인" {
            val p1 = Person("kim", "9999")
            val p2 = Person("lee", "0000")

            (p1 < p2) shouldBe true
            (p1 <= p2) shouldBe true
            (p1 >= p2) shouldBe false
            (p1 > p2) shouldBe false
        }

        "번호로 정상적으로 비교되는지 확인" {
            val p1 = Person("kim", "9999")
            val p2 = Person("kim", "0000")

            (p1 < p2) shouldBe false
            (p1 <= p2) shouldBe false
            (p1 >= p2) shouldBe true
            (p1 > p2) shouldBe true
        }
    }
}