import io.kotlintest.specs.StringSpec

class ObjectExpressionTest : StringSpec() {

    init {

    }
}

/**
 * 마치 자바의 익명 객체처럼 바로 구현하면서 인자로 넘겨버릴 수 있다.
 * 주의할 것은 여기서 object 는 싱글턴이 아니라 매 요청마다 객체가 생성되므로
 * 시스템에 부하를 줄 수 있다는 점이다.
 */
fun countClicks(window: Window) {
    var count = 0

    window.addMouseListener(
        object : MouseAdaptor {
            override fun mouseClicked(e: MouseEvent) {
                count++
            }

            override fun mouseEntered(e: MouseEvent) {
                count++
            }
        }
    )
}

class Window {
    fun addMouseListener(mouseAdaptor: MouseAdaptor) {
        TODO("Not yet implemented")
    }
}

interface MouseAdaptor {
    fun mouseClicked(e: MouseEvent)
    fun mouseEntered(e: MouseEvent)
}

class MouseEvent