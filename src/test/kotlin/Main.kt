import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

fun getNum() = 5

class Main : StringSpec() {

    init {

        "hi length is 2" {
            "hi".length shouldBe 2
        }

        "getNum method should return 5" {
            getNum() shouldBe 5
        }
    }
}
