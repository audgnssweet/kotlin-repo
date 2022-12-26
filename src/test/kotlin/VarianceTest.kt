import io.kotlintest.specs.StringSpec

class VarianceTest : StringSpec() {

    /**
     * 공변 - 제네릭의 원시타입과 제네릭 타입 중 제네릭 타입의 슈퍼 - 서브 타입 관계 설정
     *
     * [종류]
     * 불변형 - 기본
     * 공변형 - out (extends)
     * 반공변형 - in (super)
     *
     * 변형 제한자를 통해 나타낸다.
     *
     * out 은 꺼내기만 가능해서 out
     * in 은 넣기만 가능해서 in
     *
     * 그래서 코틀린의 Mutable XXX 는 불변형 으로 선언되어 있고
     * Immutable XXX 는 공변형으로 선언되어 있다.
     *
     * List<E>
     * MutableList<out E>
     *
     * 불변형은 사용 시점에 공변 혹은 반공변을 결정할 수 있다.
     * List<out E>
     *
     * 하지만 기존에 공변이거나 반공변이면 할 수 없다. 충돌나니까
     */
    init {

    }

    /**
     * out, in 의 진짜 목적은 notion 참고
     */

    //꺼내기만 된다
    interface Box<out T> {
        fun get(): T
        fun set(elem: T)
    }

    //넣기만 된다
    interface Box2<in T> {
        fun get(): T
        fun set(elem: T)
    }

    class ConcreteBox<out T> : Box<T> {

        lateinit var elem: T

        override fun get(): T {
        }

        override fun set(elem: T) {
            this.elem = elem
        }
    }

    fun exam() {
        val b: Box<Number> = ConcreteBox<Int>()
        b.set(1.0)
    }

    class InBox<in T>() {

    }
}