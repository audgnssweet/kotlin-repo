import io.kotlintest.specs.StringSpec

/**
 * 위임 : 인자로 받아서 다형성을 구현하는 것을 by 위임을 통해서 쉽게 구현할 수 있다.
 * 위처럼 위임을 해주면
 * 사실은 아래처럼 된다.
 */
class WindowBy(val figure: Figure) : Figure by figure

class WindowByReal(val figure: Figure) {
    fun draw() {
        figure.draw()
    }

    fun fill() {
        figure.fill()
    }
}

class DelegationTest : StringSpec() {

    init {
        "hi" {
            val r = Rectangle()
            val c = Circle()

            WindowBy(r).draw()
            WindowBy(c).fill()
        }
    }
}

interface Figure {
    fun draw()
    fun fill()
}

class Rectangle : Figure {
    override fun draw() {
        println("draw rectangle")
    }

    override fun fill() {
        println("fill rectangle")
    }
}

class Circle : Figure {
    override fun draw() {
        println("draw circle")
    }

    override fun fill() {
        println("fill circle")
    }
}

