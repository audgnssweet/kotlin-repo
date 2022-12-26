import io.kotlintest.specs.StringSpec

class EnumTest : StringSpec() {

    init {

        "RGB" {

        }

    }
}

enum class Color {
    RED, GREEN, BLUE
}

enum class RGB(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255);

    fun rgbValue() = (r * 256 + g) * 256 + b
}


